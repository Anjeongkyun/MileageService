package com.jeognykun.triple.mileage.mileageservice.handler;

import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.service.EventActionService;
import com.jeognykun.triple.mileage.mileageservice.service.EventAddService;
import com.jeognykun.triple.mileage.mileageservice.service.EventDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class EventActionHandler {

    private final EventAddService eventAddService;
//    private final EventModService eventModService;
    private final EventDeleteService eventDeleteService;


    public EventActionService actionTypeHandler(EventRequest req){

        EventActionService eventService = null;

        switch (req.getAction()){
            case ADD:
                eventService = new EventActionService(eventAddService);
                break;
            case DELETE:
                eventService = new EventActionService(eventDeleteService);
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Unknown action type : %s", req.getAction())
                );
        }

        return eventService;
    }
}
