-- DELETE FROM teacher;
-- DELETE FROM address;
-- DELETE FROM speciality;
-- DELETE FROM study_group;
DELETE FROM users;
DELETE FROM user_roles;

-- -- teacher
-- INSERT INTO public.teacher (first_name, last_name, middle_name, rank) VALUES ('Василий', 'Васильев', 'Васильевич', 'Майор'); 
-- 
-- -- address
-- INSERT INTO public.address (city, street, house, apartment) VALUES ('Витебск', 'Ленина', '14', '5'); 
-- 
-- -- speciality
-- INSERT INTO public.speciality (title) VALUES ('Чочочеведение');
-- 
-- -- group
-- INSERT INTO public.study_group (title, speciality_id) VALUES ('АО1', 7);

-- authentification
insert into public.users (id, person_id, login, password, enabled) values (0, 0, 'admin', '12345', 1);
insert into public.users (id, person_id, login, password, enabled) values (1, 1, 'teacher', '12345', 1);
insert into public.users (id, person_id, login, password, enabled) values (2, 2, 'student', '12345', 1);

insert into public.user_roles (user_id, authority) values (0, 'ROLE_ADMIN');
insert into public.user_roles (user_id, authority) values (1, 'ROLE_TEACHER');
insert into public.user_roles (user_id, authority) values (2, 'ROLE_STUDENT');