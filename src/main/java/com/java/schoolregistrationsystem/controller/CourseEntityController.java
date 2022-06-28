package com.java.schoolregistrationsystem.controller;

import com.java.schoolregistrationsystem.model.CourseCRUD.CourseCreationDTO;
import com.java.schoolregistrationsystem.model.CourseCRUD.CourseDTO;
import com.java.schoolregistrationsystem.model.CourseCRUD.CourseDeleteResponse;
import com.java.schoolregistrationsystem.service.CourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation(value = "Get all courses", notes = "Get information about all courses")
    public ResponseEntity<Page<CourseDTO>> getAllCourses(@ApiParam(value =
            "In Json provide page number and size of the page") Pageable pageable) {
        return ResponseEntity.ok(courseService.getAllDTOs(pageable));
    }

    @GetMapping("/{name}")
    @ApiOperation(value = "Get course by its name", notes = "Gets information about specific course based on its name")
    public ResponseEntity<CourseDTO> getCourseByName(@ApiParam(value = "Provide course name in url")
                                                         @PathVariable String name) {
        return ResponseEntity.ok(courseService.getDTOByName(name));
    }

    @PostMapping
    @ApiOperation(value = "Create new course")
    public ResponseEntity<CourseDTO> createCourse(@ApiParam(value = "Provide course name in Json")
                                                      @RequestBody CourseCreationDTO creationDTO) {
        return ResponseEntity.ok(courseService.createDTO(creationDTO));
    }

    @DeleteMapping("/{name}")
    @ApiOperation(value = "Delete selected course")
    public ResponseEntity<CourseDeleteResponse> deleteCourse(@ApiParam(value =
            "Provide name of the course you would like to delete in url") @PathVariable String name) {
        return ResponseEntity.ok(courseService.deleteDTO(name));
    }

}
