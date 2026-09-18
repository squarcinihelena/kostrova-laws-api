package com.ballet.auditor.service;

import com.ballet.auditor.dto.request.LessonPlanCreateRequest;
import com.ballet.auditor.dto.request.PlanItemRequest;
import com.ballet.auditor.dto.response.LessonPlanResponse;
import com.ballet.auditor.model.*;
import com.ballet.auditor.repository.DanceClassRepository;
import com.ballet.auditor.repository.ExerciseCatalogRepository;
import com.ballet.auditor.repository.LessonPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonPlanService {

    private final LessonPlanRepository lessonPlanRepository;
    private final DanceClassRepository danceClassRepository;
    private final ExerciseCatalogRepository exerciseCatalogRepository;
    private final ExerciseAuditorService auditorService;

    @Transactional
    public LessonPlanResponse createPlan(LessonPlanCreateRequest request) {
        DanceClass danceClass = danceClassRepository.findById(request.getClassId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com o ID: " + request.getClassId()));

        LessonPlan plan = LessonPlan.builder()
                .danceClass(danceClass)
                .bimonthPeriod(request.getBimonthPeriod())
                .createdAt(LocalDateTime.now())
                .items(new ArrayList<>())
                .build();

        for (PlanItemRequest itemReq : request.getItems()) {
            ExerciseCatalog exercise = exerciseCatalogRepository.findById(itemReq.getExerciseId())
                    .orElseThrow(() -> new RuntimeException("Exercicio não encontrado com o ID: " + itemReq.getExerciseId()));

            PlanItem item = PlanItem.builder()
                    .lessonPlan(plan)
                    .exercise(exercise)
                    .seqOrder(itemReq.getSeqOrder())
                    .build();

            plan.getItems().add(item);
        }

        AuditReport report = auditorService.auditPlan(plan);
        plan.setAuditReport(report);

        LessonPlan savedPlan = lessonPlanRepository.save(plan);

        return LessonPlanResponse.builder()
                .planId(savedPlan.getId())
                .classId(danceClass.getId())
                .className(danceClass.getName())
                .bimonthPeriod(savedPlan.getBimonthPeriod())
                .totalExercises(savedPlan.getItems().size())
                .riskLevel(report.getRiskLevel())
                .feedback(report.getFeedback())
                .auditedAt(report.getAuditedAt())
                .build();
    }
}