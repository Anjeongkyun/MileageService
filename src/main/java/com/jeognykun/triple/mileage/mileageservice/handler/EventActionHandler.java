package com.jeognykun.triple.mileage.mileageservice.handler;

import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.service.EventAddService;
import com.jeognykun.triple.mileage.mileageservice.service.EventActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventActionHandler {
    private final EventAddService eventAddService;

    public EventActionService actionTypeHandler(EventRequest req){

        EventActionService eventService = null;

        switch (req.getAction()){
            case ADD:
                eventService = new EventActionService(eventAddService);
                break;

            default:
                throw new IllegalArgumentException(
                        String.format("Unknown action type : %s", req.getAction())
                );
        }

        return eventService;
    }
}
