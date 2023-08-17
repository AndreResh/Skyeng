package com.app.controller;

import com.app.dto.PostOfficeRequest;
import com.app.model.PostOffice;
import com.app.service.PostOfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/post/office")
@RestController
@RequiredArgsConstructor
public class PostOfficeController {
    private final PostOfficeService postOfficeService;

    @PostMapping
    public ResponseEntity<?> create(@Validated  @RequestBody PostOfficeRequest postOfficeRequest){
        return ResponseEntity.ok(postOfficeService.save(postOfficeRequest));
    }

}
