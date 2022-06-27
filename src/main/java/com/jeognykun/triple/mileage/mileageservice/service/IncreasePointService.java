package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.domain.Point;
import com.jeognykun.triple.mileage.mileageservice.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class IncreasePointService {
    private final PointRepository repository;

    public Point save(String userId, long mileage) {
        Point point = Point.builder()
                .pointId(userId)
                .point(mileage + getMileage(userId))
                .build();

        return repository.save(point);
    }

    private long getMileage(String userId) {
        return repository.findById(userId).orElse(new Point(userId,0)).getPoint();
    }
}
