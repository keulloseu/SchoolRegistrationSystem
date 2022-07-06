package com.java.schoolregistrationsystem.repository;

import com.java.schoolregistrationsystem.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer>, JpaSpecificationExecutor<CourseEntity> {
    Optional<CourseEntity> findByName(String courseName);
    Optional<CourseEntity> findById(UUID id);
}
