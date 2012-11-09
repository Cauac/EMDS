-- DELETE FROM teacher;
-- DELETE FROM address;
-- DELETE FROM speciality;
-- DELETE FROM study_group;
DELETE FROM users;
DELETE FROM roles;
-- DELETE FROM user_role;

-- -- teacher
-- INSERT INTO public.teacher (first_name, last_name, middle_name, rank) VALUES ('�������', '��������', '����������', '�����'); 
-- 
-- -- address
-- INSERT INTO public.address (city, street, house, apartment) VALUES ('�������', '������', '14', '5'); 
-- 
-- -- speciality
-- INSERT INTO public.speciality (title) VALUES ('�������������');
-- 
-- -- group
-- INSERT INTO public.study_group (title, speciality_id) VALUES ('��1', 7);

-- authentication
-- insert into public.roles (id, authority) values (1, 'ROLE_ADMIN');
insert into public.roles (id, authority) values (1, 'ROLE_TEACHER');
insert into public.roles (id, authority) values (2, 'ROLE_STUDENT');

-- insert into public.users (id, login, password, enabled) values (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 1);
insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (1, 1, 'teacher', 'teacher', '8d788385431273d11e8b43bb78f3aa41', 1, 1);
insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (2, 2, 'student', 'student', 'cd73502828457d15655bbd7a63fb0bc8', 1, 2);


-- insert into public.user_role (user_id, role_id) values (1, 1);
-- insert into public.user_role (user_id, role_id) values (2, 2);
-- insert into public.user_role (user_id, role_id) values (3, 3);