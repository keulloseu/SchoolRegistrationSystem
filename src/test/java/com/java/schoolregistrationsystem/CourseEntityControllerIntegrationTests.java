package com.java.schoolregistrationsystem;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.schoolregistrationsystem.controller.CourseEntityController;
import com.java.schoolregistrationsystem.entity.CourseEntity;
import com.java.schoolregistrationsystem.model.CourseCRUD.CourseDTO;
import com.java.schoolregistrationsystem.repository.CourseRepository;
import com.java.schoolregistrationsystem.service.CourseService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CourseEntityController.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CourseEntityControllerIntegrationTests {
    @Autowired
    private MockMvc mvc;

//    private static final ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private CourseService courseService;

    @MockBean
    private CourseRepository courseRepository;

    @BeforeAll
    void startup() {
        courseRepository.saveAndFlush(new CourseEntity(UUID.randomUUID(), "asa", Set.of()));
    }

    @Test
    void getAllCoursesTest() throws Exception {
        PageRequest of = PageRequest.of(1,1);
//        Page<CourseDTO> courses = mock(Page.class);
//        when(courseRepository.findAll(any(Pageable.class)))
//                .thenReturn(courses);
//        when(courseService.getAllDTOs(any(Pageable.class)))
//                .thenReturn(courses);

        this.mvc.perform(MockMvcRequestBuilders
                .get("/entity/course"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id"). value("X"));
    }
}
