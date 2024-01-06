package com.example.bookmyshow.exception;

public class ShowNotFoundException extends RuntimeException {
    public ShowNotFoundException(String requestedShowIsNotAvailable) {
        super(requestedShowIsNotAvailable);
    }
}
