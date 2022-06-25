package com.jeognykun.triple.mileage.mileageservice.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "point")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PointEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "point")
    private long point;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "point")
    private List<PointHistoryEntity> histories = new ArrayList<>();

    @Builder
    public PointEntity(String id, long point) {
        this.id = id;
        this.point = point;
    }

    public void addHistory(PointHistoryEntity pointHistory) {
        getHistories().add(pointHistory);
    }
}
