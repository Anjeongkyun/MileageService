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
@Table(name = "point_history")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PointHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long historyId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false, updatable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "point_id", nullable = false, updatable = false)
    private Point point;

    @Builder
    public PointHistory(Event event, Point point) {
        this.event = event;
        this.point = point;
    }
}
