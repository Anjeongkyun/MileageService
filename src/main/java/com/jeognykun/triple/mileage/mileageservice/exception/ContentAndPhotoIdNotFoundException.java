package com.jeognykun.triple.mileage.mileageservice.exception;

public class ContentAndPhotoIdNotFoundException extends RuntimeException{
    private String reviewId;

    public ContentAndPhotoIdNotFoundException(String reviewId){
        this.reviewId = reviewId;
    }
}
