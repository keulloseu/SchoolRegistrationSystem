package com.java.schoolregistrationsystem;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.schoolregistrationsystem.controller.CourseEntityController;
import com.java.schoolregistrationsystem.model.CourseCRUD.CourseDTO;
import com.java.schoolregistrationsystem.repository.CourseRepository;
import com.java.schoolregistrationsystem.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Test
    void getAllCoursesTest() throws Exception {
        Page<CourseDTO> courses = mock(Page.class);
//        when(courseRepository.findAll(any(Pageable.class)))
//                .thenReturn(courses);
        when(courseService.getAllDTOs(any(Pageable.class)))
                .thenReturn(courses);

        this.mvc.perform(MockMvcRequestBuilders
                .get("/entity/course"))
                .andExpect(status().isOk());
//                .andExpect(content().json(toString(courses)));
    }
}
