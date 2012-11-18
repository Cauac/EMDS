DELETE FROM users;
DELETE FROM teacher;
DELETE FROM student;
DELETE FROM roles;
DELETE FROM study_group;
DELETE FROM specialty;

insert into public.specialty (id_specialty, title) values (0, 'Мотострелки');
insert into public.specialty (id_specialty, title) values (1, 'Саперы');
insert into public.specialty (id_specialty, title) values (2, 'Артиллеристы');
insert into public.specialty (id_specialty, title) values (3, 'Разведчики');
alter sequence public.specialty_id_specialty_seq restart with 4;

insert into public.study_group (id_group, title,specialty_id) values (0, 'М1', 0);
insert into public.study_group (id_group, title,specialty_id) values (1, 'МО1', 0);
insert into public.study_group (id_group, title,specialty_id) values (2, 'С1', 1);
insert into public.study_group (id_group, title,specialty_id) values (3, 'СО1', 1);
insert into public.study_group (id_group, title,specialty_id) values (4, 'А1', 2);
insert into public.study_group (id_group, title,specialty_id) values (5, 'АО1', 2);
insert into public.study_group (id_group, title,specialty_id) values (6, 'Р1', 3);
insert into public.study_group (id_group, title,specialty_id) values (7, 'РО1', 3);
alter sequence public.study_group_id_group_seq restart with 8;

insert into public.roles (id, authority) values (0, 'ROLE_TEACHER');
insert into public.roles (id, authority) values (1, 'ROLE_STUDENT');
alter sequence public.roles_id_seq restart with 2;

insert into public.teacher (id_teacher, first_name, last_name, middle_name, rank) values (0, 'Сергей','Машеро','Аркадьевич','Подполковник');
alter sequence public.teacher_id_teacher_seq restart with 1;

insert into public.student (id_student, first_name,last_name,middle_name,birth_date,rank, group_id)
values (0, 'Антон','Спирченок','Олегович','21/01/1992','Студент 2 курса', 5);
insert into public.student (id_student, first_name,last_name,middle_name,birth_date,rank, group_id)
values (1, 'Павел','Авсейко','Павлович','20/08/1992','Студент 2 курса', 5);
alter sequence public.student_id_student_seq restart with 2;

insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (0, 0, 'teacher', 'MasheroSA', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 1, 0);
insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (1, 0, 'student', 'SpirchenokAO', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 1, 1);
insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (2, 1, 'student', 'AvseikoPP', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 1, 1);
alter sequence public.users_id_seq restart with 3;