package com.java.schoolregistrationsystem.model;

import com.java.schoolregistrationsystem.validation.constraint.CourseConstraint;
import com.java.schoolregistrationsystem.validation.constraint.StudentConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @StudentConstraint
    private String name;
    @CourseConstraint
    private String courseName;
}
