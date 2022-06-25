package com.jeognykun.triple.mileage.mileageservice.repository;

import com.jeognykun.triple.mileage.mileageservice.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
