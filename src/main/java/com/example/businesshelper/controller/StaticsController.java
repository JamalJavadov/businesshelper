package com.example.businesshelper.controller;


import com.example.businesshelper.model.dto.StaticsDto;
import com.example.businesshelper.service.StaticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/statics")
public class StaticsController {
    private final StaticsService staticsService;

    @GetMapping("/monthly")
    public ResponseEntity<StaticsDto> getMonthlyStatics(@RequestParam Month month) {
        return ResponseEntity.ok(staticsService.monthlyStatics(month));
    }
}
