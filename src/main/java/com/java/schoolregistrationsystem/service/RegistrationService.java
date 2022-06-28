package com.java.schoolregistrationsystem.service;

import com.java.schoolregistrationsystem.entity.CourseEntity;
import com.java.schoolregistrationsystem.entity.CourseMembershipEntity;
import com.java.schoolregistrationsystem.entity.StudentEntity;
import com.java.schoolregistrationsystem.model.RegisterResponse;
import com.java.schoolregistrationsystem.model.RegistrationRequest;
import com.java.schoolregistrationsystem.repository.CourseMembershipRepository;
import com.java.schoolregistrationsystem.repository.CourseRepository;
import com.java.schoolregistrationsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final CourseMembershipRepository courseMembershipRepository;

    public ResponseEntity<RegisterResponse> registerStudent(RegistrationRequest request) {
        StudentEntity student = studentRepository.findByName(request.getName())
                .orElseThrow(() -> new EntityNotFoundException("STUDENT"));
        CourseEntity course = courseRepository.findByName(request.getCourseName())
                .orElseThrow(() -> new EntityNotFoundException("COURSE"));
        courseMembershipRepository.save(new CourseMembershipEntity(student.getId(), course.getId()));
        return ResponseEntity.ok(new RegisterResponse(true));
    }

}
