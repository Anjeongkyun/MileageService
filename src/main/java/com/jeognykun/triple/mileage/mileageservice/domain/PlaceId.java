package com.jeognykun.triple.mileage.mileageservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
public class PlaceId implements Serializable {
    @Column(name = "place_id")
    private String placeId;

    @Column(name = "user_id")
    private String userId;

    @Builder
    public PlaceId(String placeId, String userId) {
        this.placeId = placeId;
        this.userId = userId;
    }
}
