create table address (
    id_address SERIAL,
    city varchar(30) NOT NULL,
    street varchar (50) NOT NULL,
    house varchar (3) NOT NULL,
    block varchar (3),
    apartment varchar (4),
    PRIMARY KEY("id_address")
);

create table speciality (
    id_speciality SERIAL,
    title varchar (100) NOT NULL,
    PRIMARY KEY("id_speciality")
);

create table study_group (
    id_group SERIAL,
    title varchar (10) UNIQUE NOT NULL,
    speciality_id int NOT NULL,
    PRIMARY KEY("id_group"),
    CONSTRAINT FK_GROUP_SPECIALITY FOREIGN KEY (speciality_id) REFERENCES speciality(id_speciality) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE questionnaire(
    id_questionnaire SERIAL,
    birth_place varchar (50),
    nationality varchar (20),
    passport_number varchar(10),
    address_id int,
    mobile_tel varchar(10),
    home_tel varchar(10),
    
    admission_year varchar (4),
    faculty varchar (30),
    speciality varchar (30),
    course int,
    study_group varchar (10),
    study_progress real,
    curator varchar (30),
    curator_tel varchar (10),
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
    parent_tel varchar(10),
    
    education_before varchar (100),
    faculty_public_life varchar (100),
    hobby varchar (100),
    public_organization varchar (100),
    employment varchar (100),
    how_did_you_hear_about varchar (100),
    desire_to_continue varchar (100),
    think_about_study varchar (100),
    think_about_duty varchar (100),
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
    rank varchar(20),
    PRIMARY KEY("id_student"),
    CONSTRAINT FK_STUDENT_GROUP FOREIGN KEY (group_id) REFERENCES study_group(id_group) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_STUDENT_QUESTIONNAIRE FOREIGN KEY (questionnaire_id) REFERENCES questionnaire(id_questionnaire) ON DELETE CASCADE ON UPDATE CASCADE
);

create table subject (
    id_subject SERIAL,
    "title" varchar(100) NOT NULL,
    PRIMARY KEY("id_subject")
);

create table speciality_subject (
    subject_id int NOT NULL,
    speciality_id int NOT NULL,
    CONSTRAINT FK_SPECIALITY FOREIGN KEY (speciality_id) REFERENCES speciality(id_speciality) ON DELETE CASCADE ON UPDATE CASCADE,
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
    progress_result varchar (1),
    progress_date date NOT NULL,
    CONSTRAINT FK_PROGRESS_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject(id_subject) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_PROGRESS_STUDENT FOREIGN KEY (student_id) REFERENCES student(id_student) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY("id_progress")
);


