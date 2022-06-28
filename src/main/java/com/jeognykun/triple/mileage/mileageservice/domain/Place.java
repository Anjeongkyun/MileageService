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
@Table(name = "place")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place extends BaseTime{

    @Id
    @Column(name = "id")
    private String placeId;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private String value;

    @Builder
    public Place(String placeId, String type, String value) {
        this.placeId = placeId;
        this.type = type;
        this.value = value;
    }
}
