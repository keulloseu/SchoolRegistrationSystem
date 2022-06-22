package com.java.schoolregistrationsystem.service;

import com.java.schoolregistrationsystem.entity.CourseEntity;
import com.java.schoolregistrationsystem.model.CourseCRUD.CourseCreationDTO;
import com.java.schoolregistrationsystem.model.CourseCRUD.CourseDTO;
import com.java.schoolregistrationsystem.model.CourseCRUD.CourseDeleteResponse;
import com.java.schoolregistrationsystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public Page<CourseDTO> getAllDTOs(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));
        return courseRepository.findAll(pageable)
                .map(courseResponseEntity -> modelMapper.map(courseResponseEntity, CourseDTO.class));
    }

    public CourseDTO getDTOByName(String name) {
        return modelMapper.map(courseRepository.findByName(name).orElse(null), CourseDTO.class);
    }

    public CourseDTO createDTO(CourseCreationDTO courseCreationDTO) {
        return modelMapper
                .map(courseRepository.save(modelMapper.map(courseCreationDTO, CourseEntity.class)), CourseDTO.class);
    }

    public CourseDeleteResponse deleteCourse(String name) {
        Optional<CourseEntity> optCourse = courseRepository.findByName(name);
        if (optCourse.isPresent()) {
            courseRepository.delete(optCourse.get());
            return new CourseDeleteResponse(true);
        } else {
            return new CourseDeleteResponse(false);
        }
    }
}
