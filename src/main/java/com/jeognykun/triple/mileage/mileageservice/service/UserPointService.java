package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.domain.Point;
import com.jeognykun.triple.mileage.mileageservice.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserPointService {
    private final PointRepository repository;

    public Point get(String userId) {
        return repository.findById(userId).orElseThrow(() -> new IllegalArgumentException(
                String.format("Unknown userId : %s", userId)
        ));
    }
}
