package com.java.schoolregistrationsystem.repository;

import com.java.schoolregistrationsystem.entity.CourseMembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourseMembershipRepository extends JpaRepository<CourseMembershipEntity, Integer> {
    List<CourseMembershipEntity> findAllByStudentId(UUID id);
    List<CourseMembershipEntity> findAllByCourseId(UUID id);
}
