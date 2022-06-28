package com.java.schoolregistrationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudentPrimaryKey implements Serializable {
    @Column(name = "student_id")
    private UUID studentId;
    @Column(name = "course_id")
    private UUID courseId;
}
