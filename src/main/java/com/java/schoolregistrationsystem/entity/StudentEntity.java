package com.java.schoolregistrationsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class StudentEntity {
    @Id
    @Column(name = "student_id")
    private UUID id;
    @Column(name = "student_name")
    private String name;
    @ManyToMany(mappedBy = "students")
    private Set<CourseEntity> courses;
}
