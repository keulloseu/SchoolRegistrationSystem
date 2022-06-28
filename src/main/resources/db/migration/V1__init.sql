CREATE TABLE Students(
                         student_id binary(16) primary key,
                         student_name varchar(50)
);

CREATE TABLE Courses(
                        course_id binary(16) primary key,
                        course_name varchar(50)
);

CREATE TABLE Course_Membership(
                                  student_id binary(16),
                                  course_id binary(16),
                                  foreign key (student_id) references Students (student_id),
                                  foreign key (course_id) references Courses (course_id),
                                  primary key (student_id, course_id)
)