package com.jeognykun.triple.mileage.mileageservice.dto;

import com.jeognykun.triple.mileage.mileageservice.domain.Event;
import com.jeognykun.triple.mileage.mileageservice.type.ActionType;
import com.jeognykun.triple.mileage.mileageservice.type.EventType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class EventResponse {

    @NotBlank
    private Long id;

    @NotBlank
    private String reviewId;

    @NotNull
    private EventType type;

    @NotNull
    private ActionType action;

    @NotBlank
    private String content;

    @NotBlank
    private String attachedPhotos;

    @NotBlank
    private String placeId;

    @NotBlank
    private long point;

    public EventResponse(Event event) {
        this.id = event.getEventId();
        this.reviewId = event.getReviewId();
        this.type = event.getType();
        this.point = event.getPoint();
        this.action = event.getAction();
        this.content = event.getContent();
        this.attachedPhotos = event.getPhoto();
        this.placeId = event.getPlaceId();
    }
}
