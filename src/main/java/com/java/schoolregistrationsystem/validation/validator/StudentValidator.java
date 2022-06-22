package com.java.schoolregistrationsystem.validation.validator;

import com.java.schoolregistrationsystem.repository.CourseMembershipRepository;
import com.java.schoolregistrationsystem.repository.StudentRepository;
import com.java.schoolregistrationsystem.validation.constraint.StudentConstraint;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class StudentValidator implements ConstraintValidator<StudentConstraint, String> {
    private final CourseMembershipRepository courseMembershipRepository;
    private final StudentRepository studentRepository;

    @Override
    public void initialize(StudentConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String studentName, ConstraintValidatorContext constraintValidatorContext) {
        if (courseMembershipRepository
                .findAllByStudentId(studentRepository.findByName(studentName).get().getId()).size() >= 5) {
            return false;
        } else return true;
    }
}
