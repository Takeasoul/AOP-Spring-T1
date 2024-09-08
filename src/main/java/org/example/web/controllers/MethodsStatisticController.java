package org.example.web.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.services.impl.MethodsStatisticsServiceImpl;
import org.example.web.DTO.response.MethodsTimeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "ExecutionTimeStatistic", description = "Статистика времени выполнения методов")
@RequestMapping("/statistics")
public class MethodsStatisticController {

        private final MethodsStatisticsServiceImpl statisticsService;

        @Operation(summary = "Получить среднее время выполнения всех методов помеченными аннотациями @TrackTime и @TrackAsyncTime")
        @GetMapping("/average-execution-time-methods")
        public ResponseEntity<List<MethodsTimeResponse>> getAvgStatistics() {
            return ResponseEntity.ok(statisticsService.getAvgExecutionTimeMethods());
        }

        @Operation(summary = "Получить максимальное время выполнения всех методов помеченными аннотациями @TrackTime и @TrackAsyncTime")
        @GetMapping("/max-execution-time-methods")
        public ResponseEntity<List<MethodsTimeResponse>> getMaxStatistics() {
            return ResponseEntity.ok(statisticsService.getMaxExecutionTimeMethods());
        }


    }
