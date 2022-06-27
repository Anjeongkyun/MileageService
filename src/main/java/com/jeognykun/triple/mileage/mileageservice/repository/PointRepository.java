package com.jeognykun.triple.mileage.mileageservice.repository;

import com.jeognykun.triple.mileage.mileageservice.domain.Place;
import com.jeognykun.triple.mileage.mileageservice.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, String>  {
}
