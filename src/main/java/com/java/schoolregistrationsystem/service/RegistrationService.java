package com.java.schoolregistrationsystem.service;

import com.java.schoolregistrationsystem.entity.CourseEntity;
import com.java.schoolregistrationsystem.entity.CourseMembershipEntity;
import com.java.schoolregistrationsystem.entity.StudentEntity;
import com.java.schoolregistrationsystem.model.RegistrationRequest;
import com.java.schoolregistrationsystem.repository.CourseMembershipRepository;
import com.java.schoolregistrationsystem.repository.CourseRepository;
import com.java.schoolregistrationsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final CourseMembershipRepository courseMembershipRepository;

    public void registerStudent(RegistrationRequest request) {
        StudentEntity student = studentRepository.findByName(request.getName()).get();
        CourseEntity course = courseRepository.findByName(request.getCourseName()).get();
        courseMembershipRepository.save(new CourseMembershipEntity(student.getId(), course.getId()));
        System.out.println(course.getId());
    }

}
