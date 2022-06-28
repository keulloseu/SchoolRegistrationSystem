package com.java.schoolregistrationsystem.controller;

import com.java.schoolregistrationsystem.model.RegisterResponse;
import com.java.schoolregistrationsystem.model.RegistrationRequest;
import com.java.schoolregistrationsystem.service.RegistrationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {
    private final RegistrationService registrationService;

    @PostMapping
    @ApiOperation(value = "Register student for course",
            notes = "Input student name and course name to register for course.")
    public ResponseEntity<RegisterResponse> registerForCourse(
                                            @ApiParam(value = "Json including student name and course name")
                                            @RequestBody @Valid RegistrationRequest request ) {
        return registrationService.registerStudent(request);
    }
}
