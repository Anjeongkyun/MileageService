package com.jeognykun.triple.mileage.mileageservice.domain;

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
public class Point extends BaseTime{

    @Id
    @Column(name = "point_id")
    private String pointId;

    @Column(name = "point")
    private long point;

    @OneToMany(mappedBy = "point")
    private List<PointHistory> histories = new ArrayList<>();

    @Builder
    public Point(String pointId, long point) {
        this.pointId = pointId;
        this.point = point;
    }

    public void addHistory(PointHistory pointHistory) {
        getHistories().add(pointHistory);
    }
}
