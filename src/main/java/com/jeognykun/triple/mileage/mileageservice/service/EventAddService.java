package com.jeognykun.triple.mileage.mileageservice.service;

import com.jeognykun.triple.mileage.mileageservice.domain.Event;
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

    @Override
    public Event eventAction(EventRequest req) {

        //텍스트, 사진 값 비어있는지 체크
        eventService.checkContentAndPhotoId(req);

        //리뷰가 해당 장소에서 첫번째 리뷰인지 체크


        //텍스트,사진 체크하여 점수 설정

        // 특정 장소일 시 +1 점 보너스


        return null;
    }
}
