package com.java.schoolregistrationsystem.controller;

import com.java.schoolregistrationsystem.model.CourseCRUD.CourseDTO;
import com.java.schoolregistrationsystem.model.StudentCRUD.StudentDTO;
import com.java.schoolregistrationsystem.service.FilterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filter")
public class FilterController {
    private final FilterService filterService;

    @GetMapping("/course/{name}")
    @ApiOperation(value = "Get all students attending selected course")
    public ResponseEntity<List<StudentDTO>> filterStudentsForCourse(@ApiParam(value = "Provide course name in url")
                                                                        @PathVariable String name) {
        return ResponseEntity.ok(filterService.filterStudentsWithCourse(name));
    }

    @GetMapping("/student/{name}")
    @ApiOperation(value = "Get all courses for selected student")
    public ResponseEntity<List<CourseDTO>> filterCoursesForStudent(@ApiParam(value = "Provide student name in url")
                                                                       @PathVariable String name) {
        return ResponseEntity.ok(filterService.filterCoursesWithStudent(name));
    }

    @GetMapping("/courses")
    @ApiOperation(value = "Get all courses without any students")
    public ResponseEntity<List<CourseDTO>> filterCoursesWithoutStudents() {
        return ResponseEntity.ok(filterService.filterEmptyCourses());
    }

    @GetMapping("/students")
    @ApiOperation(value = "Get all students that aren't registered to any course")
    public ResponseEntity<List<StudentDTO>> filterStudentsWithoutCourses() {
        return ResponseEntity.ok(filterService.filterStudentsWithoutCourses());
    }
}
