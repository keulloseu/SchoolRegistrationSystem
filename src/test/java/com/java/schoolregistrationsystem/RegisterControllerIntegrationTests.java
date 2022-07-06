package com.java.schoolregistrationsystem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.schoolregistrationsystem.controller.RegisterController;
import com.java.schoolregistrationsystem.exception.GlobalExceptionHandler;
import com.java.schoolregistrationsystem.model.RegisterResponse;
import com.java.schoolregistrationsystem.model.RegistrationRequest;
import com.java.schoolregistrationsystem.service.RegistrationService;
import com.java.schoolregistrationsystem.service.ValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RegisterController.class)
@AutoConfigureMockMvc
public class RegisterControllerIntegrationTests {
    @Autowired
    private MockMvc mvc;

    private static final ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private RegistrationService registrationService;

    @MockBean
    private ValidationService validationService;


    @Test
    void registerForCourseTest() throws Exception {
        RegistrationRequest request = new RegistrationRequest("Mikolaj Bzdon", "Dosidos");
        when(registrationService.registerStudent(any(RegistrationRequest.class)))
                .thenReturn(ResponseEntity.ok(new RegisterResponse(true)));

        when(validationService.courseAmountValidation(any(String.class)))
                .thenReturn(true);

        when(validationService.studentAmountValidation(any(String.class)))
                .thenReturn(true);

        this.mvc.perform(post("/register")
                        .content(mapper.writeValueAsString(request))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.successful").value(true));
    }

    @Test
    void registerForCourseFailStudentValidationTest() throws Exception {
        RegistrationRequest request = new RegistrationRequest("Mikolaj Bzdon", "Dosidos");
        when(registrationService.registerStudent(any(RegistrationRequest.class)))
                .thenReturn(ResponseEntity.ok(new RegisterResponse(false)));

        when(validationService.studentAmountValidation(any(String.class)))
                .thenReturn(false);

        when(validationService.courseAmountValidation(any(String.class)))
                .thenReturn(true);

        this.mvc.perform(post("/register")
                        .content(mapper.writeValueAsString(request))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.[*].message").value("Number of students for this course have been exceeded")); //DOKONCZYC !!!!!!!!!!!!!!!!!!!!!
    }
}
