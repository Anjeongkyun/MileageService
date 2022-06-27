package com.jeognykun.triple.mileage.mileageservice.service;


import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.exception.ContentAndPhotoIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {

    public void checkContentAndPhotoId(EventRequest req) {
        if(req.getAttachedPhotoIds().size() == 0 && req.getContent().length() == 0)
            throw new ContentAndPhotoIdNotFoundException(req.getReviewId());
    }
}
