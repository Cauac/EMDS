DELETE FROM users;
DELETE FROM teacher;
DELETE FROM student;
DELETE FROM roles;
DELETE FROM study_group;
DELETE FROM specialty;

insert into public.specialty (id_specialty, title) values (1, 'Мотострелки');
insert into public.specialty (id_specialty, title) values (2, 'Саперы');
insert into public.specialty (id_specialty, title) values (3, 'Артиллеристы');
insert into public.specialty (id_specialty, title) values (4, 'Разведчики');

insert into public.study_group (id_group, title,specialty_id) values (1, 'М1', 1);
insert into public.study_group (id_group, title,specialty_id) values (2, 'МО1', 1);
insert into public.study_group (id_group, title,specialty_id) values (3, 'С1', 2);
insert into public.study_group (id_group, title,specialty_id) values (4, 'СО1', 2);
insert into public.study_group (id_group, title,specialty_id) values (5, 'А1', 3);
insert into public.study_group (id_group, title,specialty_id) values (6, 'АО1', 3);
insert into public.study_group (id_group, title,specialty_id) values (7, 'Р1', 4);
insert into public.study_group (id_group, title,specialty_id) values (8, 'РО1', 4);

insert into public.roles (id, authority) values (1, 'ROLE_TEACHER');
insert into public.roles (id, authority) values (2, 'ROLE_STUDENT');

insert into public.teacher (id_teacher, first_name, last_name, middle_name, rank) values (1, 'Сергей','Машеро','Аркадьевич','Подполковник');
insert into public.student (id_student, first_name,last_name,middle_name,birth_date,rank, group_id)
values (1, 'Антон','Спирченок','Олегович','21/01/1992','Студент 2 курса', 6);
insert into public.student (id_student, first_name,last_name,middle_name,birth_date,rank, group_id)
values (2, 'Павел','Авсейко','Павлович','20/08/1992','Студент 2 курса', 6);

insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (1, 1, 'teacher', 'MasheroSA', '8d788385431273d11e8b43bb78f3aa41', 1, 1);
insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (2, 2, 'student', 'SpirchenokAO', '827ccb0eea8a706c4c34a16891f84e7b', 1, 2);
insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (3, 2, 'student', 'AvseikoPP', '827ccb0eea8a706c4c34a16891f84e7b', 1, 2);