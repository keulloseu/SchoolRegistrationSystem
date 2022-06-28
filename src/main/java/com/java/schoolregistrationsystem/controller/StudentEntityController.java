package com.java.schoolregistrationsystem.controller;

import com.java.schoolregistrationsystem.model.StudentCRUD.StudentCreationDTO;
import com.java.schoolregistrationsystem.model.StudentCRUD.StudentDTO;
import com.java.schoolregistrationsystem.model.StudentCRUD.StudentDeleteResponse;
import com.java.schoolregistrationsystem.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entity/student")
public class StudentEntityController {
    private final StudentService studentService;

    @GetMapping
    @ApiOperation(value = "Get all students")
    public ResponseEntity<Page<StudentDTO>> getAllStudents(@ApiParam(value =
            "In Json provide page number and size of the page") Pageable pageable) {
        return ResponseEntity.ok(studentService.getAllDTOs(pageable));
    }

    @GetMapping("/{name}")
    @ApiOperation(value = "Get student by its name")
    public ResponseEntity<StudentDTO> getStudentByName(@ApiParam(value = "Provide student name in url")
                                                           @PathVariable String name) {
        return ResponseEntity.ok(studentService.getDTOByName(name));
    }

    @PostMapping
    @ApiOperation(value = "Create new student")
    public ResponseEntity<StudentDTO> createStudent(@ApiParam(value = "Provide student name in Json")
                                                        @RequestBody StudentCreationDTO creationDTO) {
        return ResponseEntity.ok(studentService.createDTO(creationDTO));
    }

    @DeleteMapping("/{name}")
    @ApiOperation(value = "Delete selected student")
    public ResponseEntity<StudentDeleteResponse> deleteStudent(@ApiParam(value =
            "Provide name of the student you would like to delete in url") @PathVariable String name) {
        return ResponseEntity.ok(studentService.deleteDTO(name));
    }
}
