package com.jeognykun.triple.mileage.mileageservice.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "tb_place")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place extends BaseTime{

    @Id
    @Column(name = "id")
    private String placeId;

    @Column(name = "review_id")
    private String reviewId;

    @Builder
    public Place(String placeId, String reviewId) {
        this.placeId = placeId;
        this.reviewId = reviewId;
    }
}
