package com.app.controller;

import com.app.dto.PostDeliveryIntermediateOfficeRequest;
import com.app.dto.PostDeliveryStatusResponse;
import com.app.dto.PostalDeliveryRegistrationRequest;
import com.app.dto.ReceivedRequest;
import com.app.service.PostalDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/postal/delivery")
@RestController
@RequiredArgsConstructor
public class PostalDeliveryController {

    private final PostalDeliveryService postalDeliveryService;
    @PostMapping("/registration")
    public ResponseEntity<PostDeliveryStatusResponse> registration(@Validated @RequestBody PostalDeliveryRegistrationRequest request){
        return ResponseEntity.ok(postalDeliveryService.registration(request));
    }

    @PatchMapping("/intermediate/office/went")
    public ResponseEntity<PostDeliveryStatusResponse> intermediatePostOfficeWent(@Validated@RequestBody PostDeliveryIntermediateOfficeRequest request){
        return ResponseEntity.ok(postalDeliveryService.intermediatePostOfficeWent(request));
    }

    @PatchMapping("/intermediate/office/come")
    public ResponseEntity<PostDeliveryStatusResponse> intermediatePostOfficeCome(@Validated @RequestBody PostDeliveryIntermediateOfficeRequest request){
        return ResponseEntity.ok(postalDeliveryService.intermediatePostOfficeCome(request));
    }

    @PatchMapping("/received")
    public ResponseEntity<PostDeliveryStatusResponse> received(@Validated @RequestBody ReceivedRequest request){
        return ResponseEntity.ok(postalDeliveryService.received(request));
    }


}
