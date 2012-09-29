CREATE TABLE address (
id_address SERIAL,
city varchar(30) NULL,
street varchar (50) NULL,
house varchar (3) NULL,
block varchar (3) NULL,
apartment varchar (4) NULL,
PRIMARY KEY("id_address")
);

CREATE TABLE speciality (
id_speciality SERIAL,
title varchar (100) NULL,
PRIMARY KEY("id_speciality")
);

CREATE TABLE "group" (
id_group SERIAL,
title varchar (10) NULL,
speciality_id int NULL,
PRIMARY KEY("id_group"),
CONSTRAINT FK_GROUP_SPECIALITY FOREIGN KEY (speciality_id) REFERENCES speciality(id_speciality) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE teacher (
id_teacher SERIAL,
"name" varchar(25) NULL,
surname  varchar(50) NULL,
patronymic  varchar(30) NULL,
rank varchar(20) NULL,
PRIMARY KEY("id_teacher")
);

CREATE TABLE student (
id_student SERIAL,
"name" varchar(25) NULL,
surname  varchar(50) NULL,
patronymic  varchar(30) NULL,
birth_year varchar (4) NULL,
birth_place varchar (50) NULL,
address_id int NULL,
parents_address_id int NULL,
admission_year varchar (4) NULL,
recruitment_office varchar (40) NULL,
faculty varchar (30) NULL,
course int NULL,
education varchar (100) NULL,
service_sat
rank varchar(20) NULL,
PRIMARY KEY("id_student")
);