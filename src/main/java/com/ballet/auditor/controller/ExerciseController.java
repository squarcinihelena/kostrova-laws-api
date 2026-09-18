package com.ballet.auditor.controller;

import com.ballet.auditor.model.ExerciseCatalog;
import com.ballet.auditor.repository.ExerciseCatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseCatalogRepository exerciseCatalogRepository;

    @GetMapping
    public ResponseEntity<List<ExerciseCatalog>> listByYear(@RequestParam(defaultValue = "1") Integer year) {
        return ResponseEntity.ok(exerciseCatalogRepository.findBySyllabusYear(year));
    }
}