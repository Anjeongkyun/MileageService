package com.jeognykun.triple.mileage.mileageservice.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter
@Table(name = "tb_place_history")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceHistory extends BaseTime{

    @EmbeddedId
    private PlaceId placeId;

    @Column(name = "review_id")
    private String reviewId;

    @Builder
    public PlaceHistory(PlaceId placeId, String reviewId) {
        this.placeId = placeId;
        this.reviewId = reviewId;
    }
}
