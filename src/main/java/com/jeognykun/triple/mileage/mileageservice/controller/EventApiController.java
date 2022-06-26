package com.jeognykun.triple.mileage.mileageservice.controller;

import com.jeognykun.triple.mileage.mileageservice.domain.Event;
import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.dto.EventResponse;
import com.jeognykun.triple.mileage.mileageservice.handler.EventActionHandler;
import com.jeognykun.triple.mileage.mileageservice.service.EventActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventApiController {

    private final EventActionHandler eventActionHandler;

    @PostMapping
    public EventResponse event(@RequestBody EventRequest req){
        EventActionService eventActionService = eventActionHandler.eventHandlers(req);

        Event event = eventActionService.eventAction(req);

        return new EventResponse(event);
    }

}
