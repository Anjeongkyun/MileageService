package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.domain.Event;
import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventActionService {
    private final IEventActionService iEventActionService;

    public Event eventAction(EventRequest req){

        return this.iEventActionService.eventAction(req);
    }
}
