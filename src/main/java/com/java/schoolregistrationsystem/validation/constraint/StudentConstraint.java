package com.java.schoolregistrationsystem.validation.constraint;

import com.java.schoolregistrationsystem.validation.validator.StudentValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StudentValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentConstraint {
    String message() default "Number of courses for this student have been exceeded";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
