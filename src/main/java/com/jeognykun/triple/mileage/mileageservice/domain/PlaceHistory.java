package com.jeognykun.triple.mileage.mileageservice.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "place_history")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceHistory {

    @EmbeddedId
    @Column(name = "place_id")
    private PlaceId placeId;

    @Column(name = "review_id")
    private String reviewId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

//    @Builder
//    public PlaceHistory(PlaceId id, String value) {
//        this.id = id;
//        this.value = value;
//    }
}
