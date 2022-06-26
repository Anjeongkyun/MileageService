package com.jeognykun.triple.mileage.mileageservice.repository;

import com.jeognykun.triple.mileage.mileageservice.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, String> {
}
