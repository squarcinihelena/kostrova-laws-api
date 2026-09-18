package com.ballet.auditor.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_classes")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class DanceClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer syllabusYear;

    private String ageGroup;

    private Integer studentCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private User teacher;
}