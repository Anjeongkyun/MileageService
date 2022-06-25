package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.entity.EventEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class EventService {
    private final IEventService iEventService;

    public EventEntity eventAction(EventRequest req){

        return this.iEventService.eventAction(req);
    }
}
