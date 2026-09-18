package com.ballet.auditor.repository;

import com.ballet.auditor.model.ExerciseCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseCatalogRepository extends JpaRepository<ExerciseCatalog, Long> {
    List<ExerciseCatalog> findBySyllabusYear(Integer syllabusYear);
}