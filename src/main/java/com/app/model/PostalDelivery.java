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
@Table(name = "postal_delivery")
public class PostalDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Long indexRecipient;
    private String addressRecipient;
    private String nameRecipient;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "post_office_id")
    @JsonIgnore
    private PostOffice postOffice;

    public PostalDelivery(Type type, Status status, Long indexRecipient, String addressRecipient, String nameRecipient, PostOffice postOffice) {
        this.type = type;
        this.status = status;
        this.indexRecipient = indexRecipient;
        this.addressRecipient = addressRecipient;
        this.nameRecipient = nameRecipient;
        this.postOffice = postOffice;
    }
}
