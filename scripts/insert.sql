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

insert into public.study_group (id_group, title,specialty_id) values (0, 'М1', 0);
insert into public.study_group (id_group, title,specialty_id) values (1, 'МО1', 0);
insert into public.study_group (id_group, title,specialty_id) values (2, 'С1', 1);
insert into public.study_group (id_group, title,specialty_id) values (3, 'СО1', 1);
insert into public.study_group (id_group, title,specialty_id) values (4, 'А1', 2);
insert into public.study_group (id_group, title,specialty_id) values (5, 'АО1', 2);
insert into public.study_group (id_group, title,specialty_id) values (6, 'Р1', 3);
insert into public.study_group (id_group, title,specialty_id) values (7, 'РО1', 3);

insert into public.roles (id, authority) values (0, 'ROLE_TEACHER');
insert into public.roles (id, authority) values (1, 'ROLE_STUDENT');

insert into public.teacher (id_teacher, first_name, last_name, middle_name, rank) values (0, 'Сергей','Машеро','Аркадьевич','Подполковник');
insert into public.student (id_student, first_name,last_name,middle_name,birth_date,rank, group_id)
values (0, 'Антон','Спирченок','Олегович','21/01/1992','Студент 2 курса', 6);
insert into public.student (id_student, first_name,last_name,middle_name,birth_date,rank, group_id)
values (1, 'Павел','Авсейко','Павлович','20/08/1992','Студент 2 курса', 6);

insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (0, 0, 'teacher', 'MasheroSA', '8d788385431273d11e8b43bb78f3aa41', 1, 0);
insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (1, 0, 'student', 'SpirchenokAO', '827ccb0eea8a706c4c34a16891f84e7b', 1, 1);
insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (2, 1, 'student', 'AvseikoPP', '827ccb0eea8a706c4c34a16891f84e7b', 1, 1);