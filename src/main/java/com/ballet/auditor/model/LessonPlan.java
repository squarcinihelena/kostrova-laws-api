package com.ballet.auditor.model;

import com.ballet.auditor.model.enums.TermPeriod;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_lesson_plans")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class LessonPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    private DanceClass danceClass;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TermPeriod bimonthPeriod;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "lessonPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("seqOrder ASC")
    @Builder.Default
    private List<PlanItem> items = new ArrayList<>();

    @OneToOne(mappedBy = "lessonPlan", cascade = CascadeType.ALL)
    private AuditReport auditReport;
}