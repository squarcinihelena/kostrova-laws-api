package com.ballet.auditor.model;

import com.ballet.auditor.model.enums.ExerciseBlock;
import com.ballet.auditor.model.enums.ImpactLevel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_exercises_catalog")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ExerciseCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer syllabusYear;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ExerciseBlock block;

    @Column(nullable = false)
    private String targetMuscle;

    @Column(nullable = false)
    private String joint;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ImpactLevel impactLevel;

    @Column(length = 1000)
    private String biomechanicalRule;
}