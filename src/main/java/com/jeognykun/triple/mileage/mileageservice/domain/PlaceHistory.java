package com.jeognykun.triple.mileage.mileageservice.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "place_history")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceHistory extends BaseTime{

    @EmbeddedId
    @Column(name = "place_id")
    private PlaceId placeId;

    @Column(name = "review_id")
    private String reviewId;

//    @CreationTimestamp
//    @Column(name = "created_at", updatable = false)
//    private LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    private LocalDateTime updateAt;

    @Builder
    public PlaceHistory(PlaceId placeId, String reviewId) {
        this.placeId = placeId;
        this.reviewId = reviewId;
    }
}
