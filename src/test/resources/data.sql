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
);

insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Mikolaj Bzdon');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Michal Bzdon');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Piotr Wazny');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Filip Dulny');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Maciej Grzybowski');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Michal Gebler');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Grzegorz Burak');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Andrzej Strzelba');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Bartosz Strugalski');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Twoja Stara');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Twoj Stary');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Weed Man');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Rogal DDL');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Andrzej Chujowicz');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Mateusz Chuj');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Michal Kutaz');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Waldemar Cpun');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Piotr Jaracz');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Juliusz Farmazon');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Mikolaj Zapierdalacz');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Antoni Beniz');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Jaroslaw Chujinski');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Stonks Man');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Kizo Wnik');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'An Drzej');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Lukasz Palacz');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Rychu Peja');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Asap Rocky');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Najebany Stary');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Magik Paktofonika');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Hemp Gru');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Wilku WDZ');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Popek Firma');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Giga Grzdyla');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Malik Montana');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Diho Raz');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Kaz Balagane');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Josef Bratan');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Firma JP');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Mlody Dron');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Rafal Skt');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Stary Pijany');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Stara Pijana');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Najebana Stara');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Sebastian Alvarez');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Wujek Ali');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Inspektor Gandziet');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Key Glock');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Masayoshi Soken');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Young Dolph');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Chief Keef');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'King Sento');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Young Thug');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Andrzej Skun');
insert into Students(student_id, student_name) VALUES (UUID_TO_BIN(UUID()), 'Rafal Pojeb');

insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Wedding Cake');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Dosidos');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Ice Cream Cake');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Runtz');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Gelate');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Blue Dream');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Sour Diesel');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'GSC');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'OG Kush');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Purple Punch');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Zkittlez');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'White Widow');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Jack Herer');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Biscotti');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Northern Lights');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Pineapple Express');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Peanut Butter Breath');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Apple Fritter');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Cereak Milk');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Mimosa');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Durban Poison');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Gushers');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Gary Payton');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Kush Mints');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Green Crack');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Sundae Driver');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Bubba Kush');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Slurricane');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'White Runtz');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Cherry Pie');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Strawberry Cough');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'London Pound Cake');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Oreoz');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Chemdawg');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Wedding Crasher');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Pink Runtz');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Cheetah Piss');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Stardawg');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Trainwreck');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Lava Cake');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Animal Mints');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Grease Monkey');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Amnesia Haze');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Cookies and Cream');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Forbidden Fruit');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Mendo Breath');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Super Lemon Haze');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Grape Ape');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Bruce Banner');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Blueberry');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Lemon Haze');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Blue Cookies');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Jet Fuel');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Blue Cheese');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Zookies');
insert into courses(course_id, course_name) VALUES (UUID_TO_BIN(UUID()), 'Tropicana Cookies');

