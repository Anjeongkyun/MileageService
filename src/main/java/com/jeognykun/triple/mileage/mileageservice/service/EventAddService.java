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
public class EventAddService implements IEventActionService {

    private final EventService eventService;
    private final PlaceService placeService;
    private final CalculatePointService calculatePointService;
//    private final ReviewSaveService reviewSaveService;

    @Override
    public Event eventAction(EventRequest req) {

        eventService.checkContentAndPhotoId(req);

        Place place = placeService.isSpecial(req.getPlaceId());

        long mileage = calculatePointService.contentCalculate(req)
                + placeService.getPlaceMileage(req,place);


        return null;
    }
}
