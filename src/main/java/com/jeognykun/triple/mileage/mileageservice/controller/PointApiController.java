package com.jeognykun.triple.mileage.mileageservice.controller;

import com.jeognykun.triple.mileage.mileageservice.dto.PointResponse;
import com.jeognykun.triple.mileage.mileageservice.service.UserPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/points")
public class PointApiController {

    private final UserPointService getUserPointService;

    @GetMapping("/{id}")
    private PointResponse getPoint(@PathVariable String id){

        return new PointResponse(getUserPointService.get(id));
    }
}
