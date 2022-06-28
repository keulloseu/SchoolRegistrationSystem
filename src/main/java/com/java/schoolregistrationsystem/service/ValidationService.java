package com.java.schoolregistrationsystem.service;

import com.java.schoolregistrationsystem.entity.CourseEntity;
import com.java.schoolregistrationsystem.entity.StudentEntity;
import com.java.schoolregistrationsystem.repository.CourseMembershipRepository;
import com.java.schoolregistrationsystem.repository.CourseRepository;
import com.java.schoolregistrationsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ValidationService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseMembershipRepository courseMembershipRepository;

    @Value("${student.max.courses}")
    private int maxCourses;

    @Value("${course.max.students}")
    private int maxStudents;

    public boolean courseAmountValidation(String studentName) {
        StudentEntity student = studentRepository.findByName(studentName)
                .orElseThrow(() -> new EntityNotFoundException("Student with given name does not exist"));
        if (courseMembershipRepository.findAllByStudentId(student.getId()).size() >= maxCourses) {
            return false;
        } else return true;
    }

    public boolean studentAmountValidation(String courseName) {
        CourseEntity course = courseRepository.findByName(courseName)
                .orElseThrow(() -> new EntityNotFoundException("Course with this name does not exist"));
        if (courseMembershipRepository.findAllByCourseId(course.getId()).size() >= maxStudents) {
            return false;
        } else return true;
    }
}
