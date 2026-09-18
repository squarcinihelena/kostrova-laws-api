package com.ballet.auditor.repository;

import com.ballet.auditor.model.DanceClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanceClassRepository extends JpaRepository<DanceClass, Long> {
    List<DanceClass> findByTeacherId(Long teacherId);
}