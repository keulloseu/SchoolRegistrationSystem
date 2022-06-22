package com.java.schoolregistrationsystem.controller;

import com.java.schoolregistrationsystem.model.CourseCRUD.CourseCreationDTO;
import com.java.schoolregistrationsystem.model.CourseCRUD.CourseDTO;
import com.java.schoolregistrationsystem.model.CourseCRUD.CourseDeleteResponse;
import com.java.schoolregistrationsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entity/course")
public class CourseEntityController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<Page<CourseDTO>> getAllCourses(Pageable pageable) {
        return ResponseEntity.ok(courseService.getAllDTOs(pageable));
    }

    @GetMapping("/{name}")
    public ResponseEntity<CourseDTO> getCourseByName(@PathVariable String name) {
        return ResponseEntity.ok(courseService.getDTOByName(name));
    }

    @PostMapping()
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseCreationDTO creationDTO) {
        return ResponseEntity.ok(courseService.createDTO(creationDTO));
    }


    //nie dziala
    @DeleteMapping("/{name}")
    public ResponseEntity<CourseDeleteResponse> deleteCourse(@PathVariable String name) {
        return ResponseEntity.ok(courseService.deleteCourse(name));
    }

}
