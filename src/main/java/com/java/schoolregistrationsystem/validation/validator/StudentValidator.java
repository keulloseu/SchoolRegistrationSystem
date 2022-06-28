package com.java.schoolregistrationsystem.validation.validator;

import com.java.schoolregistrationsystem.service.ValidationService;
import com.java.schoolregistrationsystem.validation.constraint.StudentConstraint;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class StudentValidator implements ConstraintValidator<StudentConstraint, String> {
    private final ValidationService validationService;

    @Override
    public void initialize(StudentConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String studentName, ConstraintValidatorContext constraintValidatorContext) {
        return validationService.courseAmountValidation(studentName);
    }
}
