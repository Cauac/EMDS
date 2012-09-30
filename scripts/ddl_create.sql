CREATE TABLE address (
id_address SERIAL,
city varchar(30) NOT NULL,
street varchar (50) NOT NULL,
house varchar (3) NOT NULL,
block varchar (3),
apartment varchar (4) NOT NULL,
PRIMARY KEY("id_address")
);

CREATE TABLE speciality (
id_speciality SERIAL,
title varchar (100) NOT NULL,
PRIMARY KEY("id_speciality")
);

CREATE TABLE "group" (
id_group SERIAL,
title varchar (10) UNIQUE NOT NULL,
speciality_id int NOT NULL,
PRIMARY KEY("id_group"),
CONSTRAINT FK_GROUP_SPECIALITY FOREIGN KEY (speciality_id) REFERENCES speciality(id_speciality) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE teacher (
id_teacher SERIAL,
"name" varchar(50) NOT NULL,
last_name  varchar(50) NOT NULL,
middle_name  varchar(50) NOT NULL,
rank varchar(20),
PRIMARY KEY("id_teacher")
);

CREATE TABLE student (
id_student SERIAL,
"name" varchar(50) NOT NULL,
last_name  varchar(50) NOT NULL,
middle_name  varchar(50) NOT NULL,
birth_year varchar (4),
birth_place varchar (50),
address_id int,
parents_address_id int,
admission_year varchar (4),
recruitment_office varchar (40),
faculty varchar (30),
course int,
education varchar (100),
service_start Date, 
service_end Date, 
education_start Date, 
education_end Date, 
characteristic varchar(10000),
rank varchar(20),
PRIMARY KEY("id_student")
);

CREATE TABLE subject (
id_subject SERIAL,
"name" varchar(100) NOT NULL,
PRIMARY KEY("id_subject")
);

CREATE TABLE speciality_subject (
subject_id int NOT NULL,
speciality_id int NOT NULL,
CONSTRAINT FK_SPECIALITY FOREIGN KEY (speciality_id) REFERENCES speciality(id_speciality) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject(id_subject) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE course (
id_course SERIAL,
teacher_id int NOT NULL,
subject_id int NOT NULL,
group_id int NOT NULL,
CONSTRAINT FK_COURSE_TEACHER FOREIGN KEY (teacher_id) REFERENCES teacher(id_teacher) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_COURSE_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject(id_subject) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_COURSE_GROUP FOREIGN KEY (group_id) REFERENCES "group"(id_group) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY("id_course")
);

CREATE TABLE progress (
id_progress SERIAL,
student_id int NOT NULL,
subject_id int NOT NULL,
progress_result varchar (1),
progress_date date NOT NULL,
CONSTRAINT FK_PROGRESS_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject(id_subject) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_PROGRESS_STUDENT FOREIGN KEY (student_id) REFERENCES student(id_student) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY("id_progress")
);