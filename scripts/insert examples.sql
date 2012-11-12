DELETE FROM users;
DELETE FROM roles;

insert into public.roles (id, authority) values (1, 'ROLE_TEACHER');
insert into public.roles (id, authority) values (2, 'ROLE_STUDENT');

insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (1, 1, 'teacher', 'teacher', '8d788385431273d11e8b43bb78f3aa41', 1, 1);
insert into public.users (id, person_id, person_type, login, password, enabled, role_id) values (2, 2, 'student', 'student', 'cd73502828457d15655bbd7a63fb0bc8', 1, 2);