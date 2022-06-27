package com.jeognykun.triple.mileage.mileageservice.service;


import com.jeognykun.triple.mileage.mileageservice.domain.Event;
import com.jeognykun.triple.mileage.mileageservice.domain.Point;
import com.jeognykun.triple.mileage.mileageservice.domain.PointHistory;
import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.exception.ContentAndPhotoIdNotFoundException;
import com.jeognykun.triple.mileage.mileageservice.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {

    private final IncreasePointService increasePointService;
    private final EventRepository eventRepository;

    public Event writeEvent(EventRequest req, long mileage) {

        Event event = eventBuilder(req, mileage);
        Point point = increasePointService.save(req.getUserId(), mileage);

        PointHistory pointHistory = PointHistory.builder()
                .event(event)
                .point(point)
                .build();

        event.addHistory(pointHistory);
        point.addHistory(pointHistory);

        return eventRepository.save(event);

    }

    private Event eventBuilder(EventRequest req, long mileage) {
        return Event.builder()
                .userId(req.getUserId())
                .reviewId(req.getReviewId())
                .action(req.getAction())
                .photos(req.getAttachedPhotoIds().toString())
                .content(req.getContent())
                .placeId(req.getPlaceId())
                .type(req.getType())
                .point(mileage)
                .build();
    }

    public void checkContentAndPhotoId(EventRequest req) {
        if(req.getAttachedPhotoIds().size() == 0 && req.getContent().length() == 0)
            throw new ContentAndPhotoIdNotFoundException(req.getReviewId());
    }
}
