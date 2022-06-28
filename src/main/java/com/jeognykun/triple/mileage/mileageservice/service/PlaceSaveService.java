package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.domain.Place;
import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.exception.PlaceNotFoundException;
import com.jeognykun.triple.mileage.mileageservice.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlaceSaveService {
    private final PlaceRepository placeRepository;

    public Place save(EventRequest req) {
        return placeRepository.save(Place.builder()
                .placeId(req.getPlaceId())
                .value(req.getReviewId())
                .build());
    }

    public Place hasPlace(String placeId) {
        return placeRepository.findById(placeId).orElseThrow(() -> new PlaceNotFoundException(placeId));
    }
}
