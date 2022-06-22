package com.java.schoolregistrationsystem.controller;

import com.java.schoolregistrationsystem.model.RegistrationRequest;
import com.java.schoolregistrationsystem.service.RegistrationService;
import lombok.RequiredArgsConstructor;
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
    public void registerForCourse(@RequestBody @Valid RegistrationRequest request) {
        registrationService.registerStudent(request);
    }
}
