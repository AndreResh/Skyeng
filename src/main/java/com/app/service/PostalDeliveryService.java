package com.app.service;

import com.app.dto.PostDeliveryIntermediateOfficeRequest;
import com.app.dto.PostDeliveryStatusResponse;
import com.app.dto.PostalDeliveryRegistrationRequest;
import com.app.dto.ReceivedRequest;
import com.app.model.*;
import com.app.repository.HistoryRepository;
import com.app.repository.PostOfficeRepository;
import com.app.repository.PostalDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PostalDeliveryService {

    private final PostalDeliveryRepository postalDeliveryRepository;
    private final PostOfficeRepository postOfficeRepository;
    private final HistoryRepository historyRepository;

    public PostDeliveryStatusResponse registration(PostalDeliveryRegistrationRequest request) {
        PostOffice postOffice = getPostOfficeByAddress(request.getPostOfficeAddress());
        PostalDelivery postalDelivery = new PostalDelivery(
                Type.getFromString(request.getType()),
                Status.READY,
                request.getIndexRecipient(),
                request.getAddressRecipient(),
                request.getNameRecipient(),
                postOffice
        );
        PostalDelivery saved = postalDeliveryRepository.save(postalDelivery);
        History history = new History(saved.getId(), saved.getStatus(), postOffice.getName(), postOffice.getAddress());
        historyRepository.save(history);
        return new PostDeliveryStatusResponse(history.getStatus());
    }


    public PostDeliveryStatusResponse intermediatePostOfficeWent(PostDeliveryIntermediateOfficeRequest request) {
        PostOffice postOffice = getPostOfficeByAddress(request.getAddress());
        PostalDelivery postalDelivery = getPostalDeliveryById(request.getDeliveryId());
        if(postalDelivery.getPostOffice()== null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Посылка в дороге");
        }
        if(!postalDelivery.getPostOffice().equals(postOffice)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Посылка не в этом отделении");
        }
        postalDelivery.setStatus(Status.WENT);
        postalDelivery.setPostOffice(null);
        postalDeliveryRepository.save(postalDelivery);
        History history = new History(postalDelivery.getId(), postalDelivery.getStatus(), postOffice.getName(), postOffice.getAddress());
        historyRepository.save(history);
        return new PostDeliveryStatusResponse(history.getStatus());
    }

    public PostDeliveryStatusResponse intermediatePostOfficeCome(PostDeliveryIntermediateOfficeRequest request) {
        PostOffice postOffice = getPostOfficeByAddress(request.getAddress());
        System.out.println(request);
        System.out.println(postOffice);
        PostalDelivery postalDelivery = getPostalDeliveryById(request.getDeliveryId());
        if (postalDelivery.getPostOffice() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Посылка ещё в дороге");
        postalDelivery.setPostOffice(postOffice);
        postalDelivery.setStatus(Status.COME);
        postalDeliveryRepository.save(postalDelivery);
        History history = new History(postalDelivery.getId(), postalDelivery.getStatus(), postOffice.getName(), postOffice.getAddress());
        historyRepository.save(history);
        return new PostDeliveryStatusResponse(history.getStatus());
    }

    public PostDeliveryStatusResponse received(ReceivedRequest request) {
        PostalDelivery postalDelivery = getPostalDeliveryById(request.getDeliveryId());
        PostOffice postOffice = getPostOfficeByAddress(postalDelivery.getPostOffice().getAddress());
        if (!postOffice.getAddress().equalsIgnoreCase(request.getAddress()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Посылка ещё не прибыла");
        if (!postalDelivery.getNameRecipient().equalsIgnoreCase(request.getName()))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Не тот получатель");
        postalDelivery.setPostOffice(null);
        postalDelivery.setStatus(Status.RECEIVED);
        postalDeliveryRepository.save(postalDelivery);
        History history = new History(postalDelivery.getId(), postalDelivery.getStatus(), postOffice.getName(), postOffice.getAddress());
        historyRepository.save(history);
        return new PostDeliveryStatusResponse(history.getStatus());
    }

    private PostOffice getPostOfficeByAddress(String postOfficeName) {
        return postOfficeRepository.findByAddress(postOfficeName)
                .orElseThrow(() -> new RuntimeException("Неизвестное почтовое отделение"));
    }

    private PostalDelivery getPostalDeliveryById(Long id) {
        return postalDeliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Неизвестная посылка"));
    }


}
