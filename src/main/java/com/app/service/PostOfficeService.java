package com.app.service;

import com.app.dto.PostOfficeRequest;
import com.app.model.PostOffice;
import com.app.repository.PostOfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostOfficeService {
    private final PostOfficeRepository postOfficeRepository;

    public PostOffice save(PostOfficeRequest postOfficeRequest){
        PostOffice postOffice = new PostOffice(postOfficeRequest.getName(), postOfficeRequest.getAddress());
        return postOfficeRepository.save(postOffice);
    }
}
