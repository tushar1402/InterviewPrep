package com.example.bookmyshow.exception;

public class ShowSeatNotAvailableException extends RuntimeException {
    public ShowSeatNotAvailableException(String selectedSeatIsSlreadyBooked) {
        super(selectedSeatIsSlreadyBooked);
    }
}
