package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceivedRequest {
    @NonNull
    private Long deliveryId;
    @NotBlank
    private String address;
    @NotBlank
    private String name;
}
