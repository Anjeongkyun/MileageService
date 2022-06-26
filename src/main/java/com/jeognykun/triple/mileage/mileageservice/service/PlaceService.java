package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.domain.PlaceHistory;
import com.jeognykun.triple.mileage.mileageservice.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;

    public void savePlaceHistory(PlaceHistory placeHistory) {
        placeRepository.save(placeHistory);
    }
}
