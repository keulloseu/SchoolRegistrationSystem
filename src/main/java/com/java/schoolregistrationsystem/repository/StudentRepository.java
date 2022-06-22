package com.java.schoolregistrationsystem.repository;

import com.java.schoolregistrationsystem.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    Optional<StudentEntity> findByName(String name);
    List<StudentEntity> findAllByName(String name);
}
