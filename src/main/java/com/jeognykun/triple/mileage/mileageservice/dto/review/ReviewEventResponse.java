package com.jeognykun.triple.mileage.mileageservice.dto.review;

import com.jeognykun.triple.mileage.mileageservice.type.ActionType;
import com.jeognykun.triple.mileage.mileageservice.type.EventType;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class ReviewEventResponse {

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
}
