package com.java.schoolregistrationsystem.service;

import com.java.schoolregistrationsystem.entity.CourseEntity;
import com.java.schoolregistrationsystem.entity.CourseMembershipEntity;
import com.java.schoolregistrationsystem.entity.StudentEntity;
import com.java.schoolregistrationsystem.model.CourseCRUD.CourseDTO;
import com.java.schoolregistrationsystem.model.StudentCRUD.StudentDTO;
import com.java.schoolregistrationsystem.repository.CourseMembershipRepository;
import com.java.schoolregistrationsystem.repository.CourseRepository;
import com.java.schoolregistrationsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilterService {
    private final CourseMembershipRepository courseMembershipRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public List<StudentDTO> filterStudentsWithCourse(String name) {
        CourseEntity course = courseRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("COURSE"));
        return courseMembershipRepository.findAllByCourseId(course.getId())
                .stream().map(CourseMembershipEntity::getStudentId)
                .map(id -> studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("STUDENT")))
                .map(student -> modelMapper.map(student, StudentDTO.class)).toList();
    }

    public List<CourseDTO> filterCoursesWithStudent(String name) {
        StudentEntity student = studentRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("STUDENT"));
        return courseMembershipRepository.findAllByStudentId(student.getId())
                .stream().map(CourseMembershipEntity::getCourseId)
                .map(id -> courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("COURSE")))
                .map(course -> modelMapper.map(course, CourseDTO.class)).toList();
    }

    public List<CourseDTO> filterEmptyCourses() {
        return courseRepository.findAll().stream()
                .filter(course -> courseMembershipRepository.findAllByCourseId(course.getId()).isEmpty())
                .map(course -> modelMapper.map(course, CourseDTO.class)).toList();
    }

    public List<StudentDTO> filterStudentsWithoutCourses() {
        return studentRepository.findAll().stream()
                .filter(student -> courseMembershipRepository.findAllByStudentId(student.getId()).isEmpty())
                .map(student -> modelMapper.map(student, StudentDTO.class)).toList();
    }
}
