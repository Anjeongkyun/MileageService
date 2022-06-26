package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.domain.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EventActionService {
    private final IEventActionService iEventActionService;

    public Event eventAction(EventRequest req){

        return this.iEventActionService.eventAction(req);
    }
}
