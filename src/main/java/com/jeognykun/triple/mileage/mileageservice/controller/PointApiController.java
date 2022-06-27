package com.jeognykun.triple.mileage.mileageservice.controller;

import com.jeognykun.triple.mileage.mileageservice.dto.PointResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/points")
public class PointApiController {

    @GetMapping("/{id}")
    private PointResponse getPoint(@PathVariable String id){

        return null;
    }
}
