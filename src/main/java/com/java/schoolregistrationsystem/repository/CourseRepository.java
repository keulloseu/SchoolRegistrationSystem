package com.java.schoolregistrationsystem.repository;

import com.java.schoolregistrationsystem.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    Optional<CourseEntity> findByName(String courseName);
}
