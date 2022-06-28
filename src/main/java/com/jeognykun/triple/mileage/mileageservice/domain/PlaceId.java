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

    @Column(name = "place_user")
    private String placeUser;

    @Builder
    public PlaceId(String placeId, String placeUser) {
        this.placeId = placeId;
        this.placeUser = placeUser;
    }
}
