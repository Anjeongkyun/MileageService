package com.jeognykun.triple.mileage.mileageservice.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Review extends BaseTime{

    @Id
    @Column(name = "review_id")
    private String reviewId;

    @Column(name = "content")
    private int content;

    @Column(name = "photo")
    private int photo;

    @Builder
    public Review(String reviewId, int content, int photo) {
        this.reviewId = reviewId;
        this.content = content;
        this.photo = photo;
    }
}
