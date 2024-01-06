package com.example.bookmyshow.service;

import com.example.bookmyshow.exception.ShowAndSeatAreNotMatching;
import com.example.bookmyshow.exception.ShowNotFoundException;
import com.example.bookmyshow.exception.ShowSeatNotAvailableException;
import com.example.bookmyshow.model.*;
import com.example.bookmyshow.repository.ShowRepository;
import com.example.bookmyshow.repository.ShowSeatRepository;
import com.example.bookmyshow.repository.TIcketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TIcketRepository ticketRepository;

    public TicketService(ShowSeatRepository showSeatRepository, ShowRepository showRepository){
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
    }
    public Ticket bookTicket(List<Long> seatShowId, Long showId) throws ShowAndSeatAreNotMatching {
        //TODO:Fetch the showSeatIds,
        List<ShowSeat> showSeats = this.showSeatRepository.findAllById(seatShowId);

        //TODO: Validate if showId and showSeat belongs to same show?


        //TODO:Check if those seats are available.

        for(ShowSeat showSeat : showSeats){
            if(showSeat.getSeatStatus() != SeatStatus.AVAILABLE){
                throw new ShowSeatNotAvailableException("Selected Seat is already booked");
            }
            if(showSeat.getShow().getId() != showId){
                throw new ShowAndSeatAreNotMatching("Show and Seat are not in same Audi");
            }
        }

        //TODO:Lock the seats.

        for (ShowSeat showSeat : showSeats){
            showSeat.setSeatStatus(SeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }
        //TODO:Create a ticket with Pending state
        Ticket ticket = new Ticket();
        ticket.setShowSeats(showSeats);
        ticket.setTicketStatus(TicketStatus.PENDING);
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(!optionalShow.isPresent()) {
            throw new ShowNotFoundException("Requested show is not available");
        }


        ticket.setShow(showRepository.findById(showId).get());
        ticket.setBookingTime(new Date());

        return ticketRepository.save(ticket);

//        return ticket;
        
    }
}
