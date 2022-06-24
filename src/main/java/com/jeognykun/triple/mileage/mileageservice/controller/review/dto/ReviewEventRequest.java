package com.jeognykun.triple.mileage.mileageservice.controller.review.dto;

import com.jeognykun.triple.mileage.mileageservice.type.ActionType;
import com.jeognykun.triple.mileage.mileageservice.type.EventType;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewEventRequest {

    @NotNull
    private EventType type;

    @NotNull
    private ActionType action;

    @NotBlank
    private String reviewId;

    @NotBlank
    private String content;

    @NotBlank
    private List<String> attachedPhotoIds;

    @NotBlank
    private String userId;

    @NotBlank
    private String placeId;

}
