DROP TABLE progress;
DROP TABLE course;
DROP TABLE specialty_subject;
DROP TABLE subject;

CREATE TABLE subject (
  id_subject SERIAL,
  "title"    VARCHAR(100) NOT NULL,
  PRIMARY KEY ("id_subject")
);

CREATE TABLE specialty_subject (
  subject_id   INT NOT NULL,
  specialty_id INT NOT NULL,
  CONSTRAINT FK_SPECIALTY FOREIGN KEY (specialty_id) REFERENCES specialty (id_specialty) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject (id_subject) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE course (
  id_course  SERIAL,
  teacher_id INT NOT NULL,
  subject_id INT NOT NULL,
  group_id   INT NOT NULL,
  CONSTRAINT FK_COURSE_TEACHER FOREIGN KEY (teacher_id) REFERENCES teacher (id_teacher) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_COURSE_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject (id_subject) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_COURSE_GROUP FOREIGN KEY (group_id) REFERENCES study_group (id_group) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY ("id_course")
);

CREATE TABLE progress (
  id_progress     SERIAL,
  student_id      INT  NOT NULL,
  subject_id      INT  NOT NULL,
  progress_result INT,
  progress_date   DATE NOT NULL,
  CONSTRAINT FK_PROGRESS_SUBJECT FOREIGN KEY (subject_id) REFERENCES subject (id_subject) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT FK_PROGRESS_STUDENT FOREIGN KEY (student_id) REFERENCES student (id_student) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY ("id_progress")
);