package com.example.bookmyshow.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private PaymentMethod paymentMethod;

    private Date timeofPayment;

    private double amount;

    private String referenceId;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private String paymentStatus;

    private Ticket ticket;
}
