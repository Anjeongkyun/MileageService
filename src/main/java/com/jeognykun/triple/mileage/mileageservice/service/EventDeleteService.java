package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.domain.Event;
import com.jeognykun.triple.mileage.mileageservice.domain.Place;
import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class EventDeleteService implements IEventActionService {

    private final EventService eventService;
    private final ReviewDeleteService reviewDeleteService;
    private final ReviewSaveService reviewSaveService;
    private final PlaceService placeService;
    private final CalculatePointService calculatePointService;

    @Override
    public Event eventAction(EventRequest req) {

        reviewSaveService.hasReview(req.getReviewId());

        Place place = placeService.getPlace(req.getPlaceId());

        long contentAndPhotoPoint = calculatePointService.contentAndPhotoPointCalculate(req);
        long placePoint = placeService.getPlaceMileage(req,place);
        long mileage = contentAndPhotoPoint + placePoint;

        placeService.setSpecialPlace(place, req.getReviewId());

        Event event = eventService.writeEvent(req, mileage);

        reviewDeleteService.delete(req.getReviewId());
        placeService.deletePlaceHistory(req.getPlaceId(), req.getUserId());
        return event;
    }
}
