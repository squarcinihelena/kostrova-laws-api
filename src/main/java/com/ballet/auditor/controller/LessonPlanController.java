package com.ballet.auditor.controller;

import com.ballet.auditor.dto.request.LessonPlanCreateRequest;
import com.ballet.auditor.dto.response.LessonPlanResponse;
import com.ballet.auditor.service.LessonPlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/plans")
@RequiredArgsConstructor
public class LessonPlanController {

    private final LessonPlanService lessonPlanService;

    @PostMapping
    public ResponseEntity<LessonPlanResponse> createPlan(@RequestBody @Valid LessonPlanCreateRequest request) {
        LessonPlanResponse response = lessonPlanService.createPlan(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}