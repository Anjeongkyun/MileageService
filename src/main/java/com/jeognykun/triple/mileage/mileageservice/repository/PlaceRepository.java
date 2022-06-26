package com.jeognykun.triple.mileage.mileageservice.repository;

import com.jeognykun.triple.mileage.mileageservice.domain.PlaceHistory;
import com.jeognykun.triple.mileage.mileageservice.domain.PlaceId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlaceRepository extends JpaRepository<PlaceHistory, PlaceId>  {
}
