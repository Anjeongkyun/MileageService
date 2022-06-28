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
public class EventModifyService implements IEventActionService {

    private final EventService eventService;
    private final ReviewSaveService reviewSaveService;
    private final PlaceService placeService;
    private final CalculatePointService calculatePointService;

    @Override
    public Event eventAction(EventRequest req) {
        eventService.checkContentAndPhotoId(req);
        reviewSaveService.hasReview(req.getReviewId());

        Place place = placeService.getPlace(req.getPlaceId());

        long contentAndPhotoPoint = calculatePointService.contentAndPhotoPointCalculate(req);
        long placePoint = placeService.getPlaceMileage(req,place);
        long mileage = contentAndPhotoPoint + placePoint;

        reviewSaveService.save(req);
        
        return eventService.writeEvent(req, mileage);

    }
}
