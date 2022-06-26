package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.domain.Place;
import com.jeognykun.triple.mileage.mileageservice.domain.PlaceHistory;
import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.repository.PlaceHistoryRepository;
import com.jeognykun.triple.mileage.mileageservice.repository.PlaceRepository;
import com.jeognykun.triple.mileage.mileageservice.type.ActionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceHistoryRepository placeHistoryRepository;
    private final PlaceRepository placeRepository;

    public void savePlaceHistory(PlaceHistory placeHistory) {
        placeHistoryRepository.save(placeHistory);
    }

    public Place isSpecial(String placeId) {
        return placeRepository.findById(placeId).orElse(null);
    }

    public long getPlaceMileage(EventRequest dto, Place place) {
        if(isAvailableFirst(dto, place)) {
            setSpecialValue(dto.getPlaceId(), dto.getReviewId());
        } else {
            return 0;
        }

        return dto.getAction().equals(ActionType.DELETE) ? -1 : 1;
    }

    public boolean isAvailableFirst(EventRequest dto, Place place) {

//        if(place != null) {
//            if(dto.getAction().equals(ActionType.DELETE)) {
//                return dto.getReviewId().equals(place.getValue());
//            } else {
//                return place.getValue() == null;
//            }
//        } else {
//            return false;
//        }
        return true;
    }

    public void setSpecialValue(String placeId, String reviewId) {
        placeRepository.save(Place.builder()
                .placeId(placeId)
                .value(reviewId)
                .build());
    }

}
