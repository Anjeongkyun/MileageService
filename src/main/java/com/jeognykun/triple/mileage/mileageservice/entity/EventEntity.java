package com.jeognykun.triple.mileage.mileageservice.entity;

import com.jeognykun.triple.mileage.mileageservice.history.PointHistory;
import com.jeognykun.triple.mileage.mileageservice.type.ActionType;
import com.jeognykun.triple.mileage.mileageservice.type.EventType;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;

    @Column(name = "type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EventType type;

    @Column(name = "action", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ActionType action;

    @Column(name = "review_id")
    private String reviewId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "point", nullable = false)
    private long point;

    @Column(name = "photo", nullable = false)
    private String photos;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "place_id", nullable = false)
    private String placeId;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<PointHistory> histories = new ArrayList<>();

    @Builder
    public EventEntity(String userId, String reviewId, String content, ActionType action, EventType type, long point, String photos, String placeId) {
        this.userId = userId;
        this.reviewId = reviewId;
        this.content = content;
        this.action = action;
        this.type = type;
        this.point = point;
        this.photos = photos;
        this.placeId = placeId;
    }
}
