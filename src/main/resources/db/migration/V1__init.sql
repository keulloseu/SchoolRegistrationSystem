CREATE TABLE Students(
                         student_id binary(16) primary key,
                         student_name varchar(50)
);

CREATE TABLE Courses(
                        course_id binary(16) primary key,
                        course_name varchar(50)
);

CREATE TABLE Course_Membership(
                                  student binary(16),
                                  course binary(16),
                                  foreign key (student) references Students (student_id),
                                  foreign key (course) references Courses (course_id),
                                  primary key (student, course)
)