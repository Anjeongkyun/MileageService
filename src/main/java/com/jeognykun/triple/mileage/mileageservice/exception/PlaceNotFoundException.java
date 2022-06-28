package com.jeognykun.triple.mileage.mileageservice.exception;

public class PlaceNotFoundException extends RuntimeException {
    private String placeId;

    public PlaceNotFoundException(String placeId) {
        this.placeId = placeId;
    }
}
