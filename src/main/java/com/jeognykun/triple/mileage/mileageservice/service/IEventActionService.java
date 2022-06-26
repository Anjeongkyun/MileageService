package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.dto.EventRequest;
import com.jeognykun.triple.mileage.mileageservice.domain.Event;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface IEventActionService {

    Event eventAction(EventRequest req);
}
