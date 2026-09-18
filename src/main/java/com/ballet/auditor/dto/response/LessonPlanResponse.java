package com.ballet.auditor.dto.response;

import com.ballet.auditor.model.enums.RiskLevel;
import com.ballet.auditor.model.enums.TermPeriod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class LessonPlanResponse {
    private Long planId;
    private Long classId;
    private String className;
    private TermPeriod bimonthPeriod;
    private Integer totalExercises;
    private RiskLevel riskLevel;
    private String feedback;
    private LocalDateTime auditedAt;
}