package com.ballet.auditor.repository;

import com.ballet.auditor.model.AuditReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuditReportRepository extends JpaRepository<AuditReport, Long> {
    Optional<AuditReport> findByLessonPlanId(Long lessonPlanId);
}