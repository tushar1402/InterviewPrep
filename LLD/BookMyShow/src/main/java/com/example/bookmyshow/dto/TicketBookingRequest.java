package com.example.bookmyshow.dto;

import com.example.bookmyshow.model.Seat;
import com.example.bookmyshow.model.Show;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketBookingRequest {

    private Long showId;
    private List<Long> showSeatId;
//    Long userId;


}
