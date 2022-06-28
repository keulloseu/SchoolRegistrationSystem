package com.java.schoolregistrationsystem.validation.constraint;

import com.java.schoolregistrationsystem.validation.validator.CourseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CourseValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseConstraint {
    String message() default "Number of students for this course have been exceeded";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
