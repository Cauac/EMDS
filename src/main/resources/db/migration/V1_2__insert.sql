DELETE FROM users;
DELETE FROM teacher;
DELETE FROM student;
DELETE FROM roles;
DELETE FROM study_group;
DELETE FROM specialty;

INSERT INTO public.specialty (id, title) VALUES (0, 'Мотострелки');
INSERT INTO public.specialty (id, title) VALUES (1, 'Саперы');
INSERT INTO public.specialty (id, title) VALUES (2, 'Артиллеристы');
INSERT INTO public.specialty (id, title) VALUES (3, 'Разведчики');
ALTER SEQUENCE public.specialty_id_seq RESTART WITH 4;

INSERT INTO public.study_group (id, title, specialty_id) VALUES (0, 'М1', 0);
INSERT INTO public.study_group (id, title, specialty_id) VALUES (1, 'МО1', 0);
INSERT INTO public.study_group (id, title, specialty_id) VALUES (2, 'С1', 1);
INSERT INTO public.study_group (id, title, specialty_id) VALUES (3, 'СО1', 1);
INSERT INTO public.study_group (id, title, specialty_id) VALUES (4, 'А1', 2);
INSERT INTO public.study_group (id, title, specialty_id) VALUES (5, 'АО1', 2);
INSERT INTO public.study_group (id, title, specialty_id) VALUES (6, 'Р1', 3);
INSERT INTO public.study_group (id, title, specialty_id) VALUES (7, 'РО1', 3);
ALTER SEQUENCE public.study_group_id_seq RESTART WITH 8;

INSERT INTO public.roles (id, authority) VALUES (0, 'ROLE_TEACHER');
INSERT INTO public.roles (id, authority) VALUES (1, 'ROLE_STUDENT');
ALTER SEQUENCE public.roles_id_seq RESTART WITH 2;

INSERT INTO public.teacher (id, first_name, last_name, middle_name, rank) VALUES (0, 'Сергей', 'Машеро', 'Аркадьевич', 'Подполковник');
ALTER SEQUENCE public.teacher_id_seq RESTART WITH 1;

INSERT INTO public.questionnaire (id, nationality) VALUES (0, 'Чукча');
ALTER SEQUENCE public.questionnaire_id_seq RESTART WITH 1;

INSERT INTO public.student (id, first_name, last_name, middle_name, birth_date, rank, group_id)
  VALUES (0, 'Антон', 'Спирченок', 'Витальевич', '21/01/1992', 'student', 5);
INSERT INTO public.student (id, first_name, last_name, middle_name, birth_date, rank, group_id, questionnaire_id)
  VALUES (1, 'Павел', 'Авсейко', 'Павлович', '20/10/1991', 'student', 5, 0);
ALTER SEQUENCE public.student_id_seq RESTART WITH 2;

INSERT INTO public.users (id, person_id, person_type, login, password, enabled, role_id) VALUES (0, 0, 'teacher', 'MasheroSA', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 1, 0);
INSERT INTO public.users (id, person_id, person_type, login, password, enabled, role_id) VALUES (1, 0, 'student', 'SpirchenokAO', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 1, 1);
INSERT INTO public.users (id, person_id, person_type, login, password, enabled, role_id) VALUES (2, 1, 'student', 'AvseikoPP', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 1, 1);
ALTER SEQUENCE public.users_id_seq RESTART WITH 3;