package com.java.schoolregistrationsystem.entity;


import com.java.schoolregistrationsystem.model.CourseStudentPrimaryKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "course_membership")
@IdClass(CourseStudentPrimaryKey.class)
public class CourseMembershipEntity {
    @Id
    @Column(name = "student")
    private UUID studentId;
    @Id
    @Column(name = "course")
    private UUID courseId;

    public CourseMembershipEntity(UUID studentId, UUID courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}
