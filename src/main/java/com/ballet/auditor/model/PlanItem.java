package com.ballet.auditor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_plan_items")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class PlanItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private LessonPlan lessonPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private ExerciseCatalog exercise;

    @Column(nullable = false)
    private Integer seqOrder;
}