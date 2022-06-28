package com.java.schoolregistrationsystem.service;

import com.java.schoolregistrationsystem.entity.StudentEntity;
import com.java.schoolregistrationsystem.model.StudentCRUD.StudentCreationDTO;
import com.java.schoolregistrationsystem.model.StudentCRUD.StudentDTO;
import com.java.schoolregistrationsystem.model.StudentCRUD.StudentDeleteResponse;
import com.java.schoolregistrationsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public Page<StudentDTO> getAllDTOs(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));
        return studentRepository.findAll(pageable)
                .map(studentResponseEntity -> modelMapper.map(studentResponseEntity, StudentDTO.class));
    }

    public StudentDTO getDTOByName(String name) {
        return modelMapper.map(studentRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("STUDENT")), StudentDTO.class);
    }

    public StudentDTO createDTO(StudentCreationDTO studentCreationDTO) {
        return modelMapper.map(studentRepository
                .save(modelMapper.map(studentCreationDTO, StudentEntity.class)), StudentDTO.class);
    }

    public StudentDeleteResponse deleteDTO(String name) {
        StudentEntity student = studentRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("STUDENT"));
        studentRepository.delete(student);
        return new StudentDeleteResponse(true);
    }
}
