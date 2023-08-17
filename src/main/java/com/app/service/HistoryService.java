package com.app.service;

import com.app.dto.PostDeliveryStatusResponse;
import com.app.model.History;
import com.app.model.PostalDelivery;
import com.app.repository.HistoryRepository;
import com.app.repository.PostalDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository historyRepository;
    private final PostalDeliveryRepository postalDeliveryRepository;

    public List<History> getAllById(Long id) {
        return historyRepository.findAllByPostalDeliveryId(id);
    }

    public PostDeliveryStatusResponse getById(Long id) {
        PostalDelivery postalDelivery = postalDeliveryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Неизвестый id доставки")
        );
        return new PostDeliveryStatusResponse(postalDelivery.getStatus());
    }
}
