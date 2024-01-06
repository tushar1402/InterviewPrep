package com.example.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Ticket extends BaseModel{

    private double totalAmount;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeats;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    private Date bookingTime;

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;

}
