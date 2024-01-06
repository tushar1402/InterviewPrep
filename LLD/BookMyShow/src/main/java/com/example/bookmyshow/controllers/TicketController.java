package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dto.TicketBookingRequest;
import com.example.bookmyshow.dto.TicketBookingResponse;
import com.example.bookmyshow.exception.ShowAndSeatAreNotMatching;
import com.example.bookmyshow.model.Ticket;
import com.example.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {

    //CRUD
    @Autowired
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public TicketBookingResponse bookTicket(TicketBookingRequest ticketBookingRequest) throws ShowAndSeatAreNotMatching {
        //Input validation
        if(ticketBookingRequest.getShowId() != null && ticketBookingRequest.getShowSeatId() != null
                && ticketBookingRequest.getShowSeatId().size() > 0){
           Ticket ticket =  this.ticketService.bookTicket(ticketBookingRequest.getShowSeatId(), ticketBookingRequest.getShowId());
           TicketBookingResponse ticketBookingResponseSuccess = new TicketBookingResponse();
           ticketBookingResponseSuccess.setTicket(ticket);
           ticketBookingResponseSuccess.setStatus("LOCKED");
           return ticketBookingResponseSuccess;
        }

        TicketBookingResponse ticketBookingResponse = new TicketBookingResponse();

        ticketBookingResponse.setMessage("Failure, not valid inputs, please give showId and seat details");
        ticketBookingResponse.setStatus("FAILURE");
        return  ticketBookingResponse;
//        return null;
    }

}
