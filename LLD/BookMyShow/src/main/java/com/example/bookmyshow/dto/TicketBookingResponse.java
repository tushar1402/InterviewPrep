package com.example.bookmyshow.dto;

import com.example.bookmyshow.model.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketBookingResponse {

    private String status;
    private String message;
    private Ticket ticket;
}
