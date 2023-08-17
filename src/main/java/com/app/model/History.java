package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postalDeliveryId;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String namePostOffice;
    private String addressPostOffice;

    public History(Long postalDeliveryId, Status status, String namePostOffice, String addressPostOffice) {
        this.postalDeliveryId = postalDeliveryId;
        this.status = status;
        this.namePostOffice = namePostOffice;
        this.addressPostOffice = addressPostOffice;
    }
}
