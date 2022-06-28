package com.java.schoolregistrationsystem.repository;

import com.java.schoolregistrationsystem.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    Optional<CourseEntity> findByName(String courseName);
    Optional<CourseEntity> findById(UUID id);
}
