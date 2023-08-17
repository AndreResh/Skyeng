package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDeliveryIntermediateOfficeRequest {
    @NonNull
    private Long deliveryId;
    @NotBlank
    private String address;
}
