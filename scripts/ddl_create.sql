drop table progress;
drop table course;
drop table specialty_subject;
drop table subject;
drop table student;
drop table teacher;
drop table questionnaire;
drop table study_group;
drop table specialty;
drop table address;

create table address (
    id_address SERIAL,
    city varchar(30) NOT NULL,
    street varchar (50) NOT NULL,
    house varchar (3) NOT NULL,
    apartment varchar (4),
    PRIMARY KEY("id_address")
);

create table specialty (
    id_specialty SERIAL,
    title varchar (300) NOT NULL,
    PRIMARY KEY("id_specialty")
);

create table study_group (
    id_group SERIAL,
    title varchar (10) UNIQUE NOT NULL,
    specialty_id int,
    PRIMARY KEY("id_group"),
    CONSTRAINT FK_GROUP_SPECIALTY FOREIGN KEY (specialty_id) REFERENCES specialty(id_specialty) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE questionnaire(
    id_questionnaire SERIAL,
    birth_place varchar (50),
    nationality varchar (20),
    passport_number varchar(10),
    address_id int,
    mobile_tel varchar(15),
    home_tel varchar(15),
    
    admission_year varchar (4),
    faculty varchar (100),
    specialty varchar (120),
    course int,
    study_group varchar (10),
    study_progress real,
    curator varchar (70),
    curator_tel varchar (15),
    education varchar (100), 
    education_start Date, 
    education_end Date, 
    education_type varchar (20),
    
    family_status varchar (20),
    mother varchar (100),
    father varchar (100),
    parents_address_id int,
    passport_office varchar(100),
    recruitment_office varchar (100),
    parent_tel varchar(15),
    
    education_before varchar (100),
    faculty_public_life varchar (300),
    hobby varchar (500),
    public_organization varchar (300),
    employment varchar (300),
    how_did_you_hear_about varchar (500),
    desire_to_continue varchar (500),
    think_about_study varchar (500),
    think_about_duty varchar (500),
    duty_start date,
    duty_end date,
    CONSTRAINT FK_ADDRESS FOREIGN KEY (address_id) REFERENCES address(id_address) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_PARENT_ADDRESS FOREIGN KEY (parents_address_id) REFERENCES address(id_address) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY("id_questionnaire")
);

create table teacher (
    id_teacher SERIAL,
    first_name varchar(50) NOT NULL,
    last_name  varchar(50) NOT NULL,
    middle_name  varchar(50) NOT NULL,
    rank varchar(20),
    PRIMARY KEY("id_teacher")
);

create table student (
    id_student SERIAL,
    first_name varchar(50) NOT NULL,
    last_name  varchar(50) NOT NULL,
    middle_name  varchar(50) NOT NULL,
    birth_date date,
    group_id int,
    questionnaire_id int, 
    characteristic varchar(10000),
    service_start Date, 
    service_end Date,
    rank varchar(50),
    PRIMARY KEY("id_student"),
    CONSTRAINT FK_STUDENT_GROUP FOREIGN KEY (group_id) REFERENCES study_group(id_group) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT FK_STUDENT_QUESTIONNAIRE FOREIGN KEY (questionnaire_id) REFERENCES questionnaire(id_questionnaire) ON DELETE CASCADE ON UPDATE CASCADE
);

create table subject (
    id_subject SERIAL,
    "title" varchar(100) NOT NULL,
    PRIMARY KEY("id_subject")
);

create table specialty_subject (
    subject_id int NOT NULL,
    specialty_id int NOT NULL,
    CONSTRAINT FK_SPECIALTY FOREIGN KEY (specialty_id) REFERENCES specialty(id_specialty) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject(id_subject) ON DELETE CASCADE ON UPDATE CASCADE
);

create table course (
    id_course SERIAL,
    teacher_id int NOT NULL,
    subject_id int NOT NULL,
    group_id int NOT NULL,
    CONSTRAINT FK_COURSE_TEACHER FOREIGN KEY (teacher_id) REFERENCES teacher(id_teacher) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_COURSE_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject(id_subject) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_COURSE_GROUP FOREIGN KEY (group_id) REFERENCES study_group(id_group) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY("id_course")
);

CREATE TABLE progress (
    id_progress SERIAL,
    student_id int NOT NULL,
    subject_id int NOT NULL,
    progress_result int,
    progress_date date NOT NULL,
    CONSTRAINT FK_PROGRESS_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject(id_subject) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_PROGRESS_STUDENT FOREIGN KEY (student_id) REFERENCES student(id_student) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY("id_progress")
);