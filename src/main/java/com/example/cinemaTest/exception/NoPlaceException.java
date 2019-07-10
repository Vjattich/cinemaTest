package com.example.cinemaTest.exception;

public class NoPlaceException extends Exception {

    @Override
    public String getMessage() {
        return "The places for this session is no more";
    }

}
