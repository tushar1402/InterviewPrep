package com.example.bookmyshow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{

    private String name;

    private SeatType seatType;
    private int row;

    private int col;

    private SeatStatus seatStatus;
}
