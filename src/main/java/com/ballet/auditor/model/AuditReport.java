package com.ballet.auditor.model;

import com.ballet.auditor.model.enums.RiskLevel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_audit_reports")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class AuditReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_plan_id", nullable = false, unique = true)
    private LessonPlan lessonPlan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RiskLevel riskLevel;

    @Column(length = 2000, nullable = false)
    private String feedback;

    @Column(nullable = false)
    private LocalDateTime auditedAt;
}