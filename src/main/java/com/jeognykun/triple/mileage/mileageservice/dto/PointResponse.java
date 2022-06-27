package com.jeognykun.triple.mileage.mileageservice.dto;

import com.jeognykun.triple.mileage.mileageservice.domain.Point;
import com.jeognykun.triple.mileage.mileageservice.domain.PointHistory;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PointResponse {

    private String userId;
    private long point;
    private List<EventResponse> histories;

    public PointResponse(Point point) {
        this.userId = point.getId();
        this.point = point.getPoint();
        this.histories = buildHistory(point.getHistories());
    }


    private List<EventResponse> buildHistory(List<PointHistory> histories) {

        List<EventResponse> eventResponses = new ArrayList<>();
        histories.forEach(obj -> eventResponses.add(new EventResponse(obj.getEvent())));

        return eventResponses;
    }
}
