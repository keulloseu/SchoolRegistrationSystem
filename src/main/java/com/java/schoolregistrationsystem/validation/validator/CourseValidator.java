package com.java.schoolregistrationsystem.validation.validator;

import com.java.schoolregistrationsystem.service.ValidationService;
import com.java.schoolregistrationsystem.validation.constraint.CourseConstraint;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class CourseValidator implements ConstraintValidator<CourseConstraint, String> {
    private final ValidationService validationService;
    @Override
    public void initialize(CourseConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String courseName, ConstraintValidatorContext constraintValidatorContext) {
        return validationService.studentAmountValidation(courseName);
    }
}
