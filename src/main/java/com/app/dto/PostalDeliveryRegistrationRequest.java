package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostalDeliveryRegistrationRequest {
    @NotBlank
    private String type;
    @NonNull
    private Long indexRecipient;
    @NotBlank
    private String addressRecipient;
    @NotBlank
    private String nameRecipient;
    @NotBlank
    private String postOfficeAddress;
}
