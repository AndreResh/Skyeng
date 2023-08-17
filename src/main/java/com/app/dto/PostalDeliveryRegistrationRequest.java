package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostalDeliveryRequest {
    @NotBlank
    private String type;
    @NotBlank
    private Long indexRecipient;
    @NotBlank
    private String addressRecipient;
    @NotBlank
    private String nameRecipient;
    @NotBlank
    private String postOfficeName;
}
