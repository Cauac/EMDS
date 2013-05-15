--
-- EMDS DB SCHEMA CREATE
--

DROP TABLE IF EXISTS student_documents;
DROP TABLE IF EXISTS document;
DROP TABLE IF EXISTS document_info;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS teacher;
DROP TABLE IF EXISTS questionnaire;
DROP TABLE IF EXISTS study_group;
DROP TABLE IF EXISTS specialty;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE address (
  id        SERIAL,
  city      VARCHAR(30) NOT NULL,
  street    VARCHAR(50) NOT NULL,
  house     VARCHAR(3)  NOT NULL,
  apartment VARCHAR(4),
  CONSTRAINT PK_ADDRESS PRIMARY KEY ("id")
);

CREATE TABLE specialty (
  id          SERIAL,
  number      VARCHAR(10)  NOT NULL,
  description VARCHAR(200) NOT NULL,
  CONSTRAINT PK_SPECIALTY PRIMARY KEY ("id")
);

CREATE TABLE study_group (
  id           SERIAL,
  title        VARCHAR(10) UNIQUE NOT NULL,
  specialty_id INT,
  CONSTRAINT PK_GROUP PRIMARY KEY ("id"),
  CONSTRAINT FK_GROUP_SPECIALTY FOREIGN KEY (specialty_id) REFERENCES specialty (id) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE questionnaire (
  id                     SERIAL,
  birth_place            VARCHAR(50),
  nationality            VARCHAR(20),
  passport_number        VARCHAR(10),
  personal_number        VARCHAR(20),
  address_id             INT,
  mobile_tel             VARCHAR(15),
  home_tel               VARCHAR(15),

  admission_year         VARCHAR(4),
  faculty                VARCHAR(100),
  specialty              VARCHAR(120),
  course                 VARCHAR(10),
  study_group_2          VARCHAR(10),
  study_group_3          VARCHAR(10),
  study_group_4          VARCHAR(10),
  study_group_5          VARCHAR(10),
  study_progress         VARCHAR(20),
  curator                VARCHAR(70),
  curator_tel            VARCHAR(15),
  education              VARCHAR(100),
  education_start        DATE,
  education_end          DATE,
  education_type         VARCHAR(20),

  family_status          VARCHAR(20),
  mother                 VARCHAR(100),
  father                 VARCHAR(100),
  parents_address_id     INT,
  passport_office        VARCHAR(100),
  recruitment_office     VARCHAR(100),
  parent_tel             VARCHAR(50),

  education_before       VARCHAR(100),
  faculty_public_life    VARCHAR(300),
  hobby                  VARCHAR(500),
  public_organization    VARCHAR(300),
  employment             VARCHAR(300),
  how_did_you_hear_about VARCHAR(500),
  desire_to_continue     VARCHAR(500),
  think_about_study      VARCHAR(500),
  think_about_duty       VARCHAR(500),
  duty                   VARCHAR(100),
  CONSTRAINT PK_QUESTIONNAIRE PRIMARY KEY ("id"),
  CONSTRAINT FK_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_PARENT_ADDRESS FOREIGN KEY (parents_address_id) REFERENCES address (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE teacher (
  id          SERIAL,
  first_name  VARCHAR(50) NOT NULL,
  last_name   VARCHAR(50) NOT NULL,
  middle_name VARCHAR(50) NOT NULL,
  rank        VARCHAR(20),
  ischief     BOOLEAN DEFAULT FALSE,
  CONSTRAINT PK_TEACHER PRIMARY KEY ("id")
);

CREATE TABLE student (
  id               SERIAL,
  first_name       VARCHAR(50) NOT NULL,
  last_name        VARCHAR(50) NOT NULL,
  middle_name      VARCHAR(50) NOT NULL,
  birth_date       DATE,
  group_id         INT,
  questionnaire_id INT,
  characteristic   VARCHAR(10000),
  student_type     VARCHAR(50),
  rank             VARCHAR(50),
  CONSTRAINT PK_STUDENT PRIMARY KEY (id),
  CONSTRAINT FK_STUDENT_GROUP FOREIGN KEY (group_id) REFERENCES study_group (id) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT FK_STUDENT_QUESTIONNAIRE FOREIGN KEY (questionnaire_id) REFERENCES questionnaire (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE document (
  id           SERIAL,
  title        CHARACTER VARYING(50),
  system_title CHARACTER VARYING(50),
  CONSTRAINT PK_DOCUMENT PRIMARY KEY (id)
);

CREATE TABLE document_info (
  id         SERIAL,
  brought    BOOLEAN,
  commentary CHARACTER VARYING(500),
  CONSTRAINT PK_DOCUMENT_INFO PRIMARY KEY (id)
);

CREATE TABLE student_documents (
  student       BIGINT NOT NULL,
  document      BIGINT NOT NULL,
  document_info BIGINT NOT NULL,
  CONSTRAINT PK_STUDENT_DOCUMENTS PRIMARY KEY (student, document),
  CONSTRAINT FK_SD_DOCUMENT FOREIGN KEY (document) REFERENCES document (id),
  CONSTRAINT FK_SD_DOCUMENT_INFO FOREIGN KEY (document_info) REFERENCES document_info (id),
  CONSTRAINT FK_SD_STUDENT FOREIGN KEY (student) REFERENCES student (id)
);

CREATE TABLE roles (
  id        SERIAL,
  authority VARCHAR(45) NOT NULL,
  CONSTRAINT PK_ROLE PRIMARY KEY (id)
);

CREATE TABLE users (
  id               SERIAL,
  person_id        BIGINT,
  person_type      VARCHAR(10),
  role_id          INT,
  login            VARCHAR(52) UNIQUE NOT NULL,
  password         VARCHAR(64)        NOT NULL,
  enabled          INT,
  default_password BOOLEAN DEFAULT TRUE,
  CONSTRAINT PK_USER PRIMARY KEY (id),
  FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE NO ACTION ON UPDATE CASCADE
);

