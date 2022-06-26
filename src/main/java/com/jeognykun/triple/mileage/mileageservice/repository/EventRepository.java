package com.jeognykun.triple.mileage.mileageservice.repository;

import com.jeognykun.triple.mileage.mileageservice.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
