DELETE FROM teacher;
DELETE FROM address;
DELETE FROM speciality;
DELETE FROM study_group;

-- teacher
INSERT INTO public.teacher (first_name, last_name, middle_name, rank) VALUES ('�������', '��������', '����������', '�����'); 

-- address
INSERT INTO public.address (city, street, house, apartment) VALUES ('�������', '������', '14', '5'); 

-- speciality
INSERT INTO public.speciality (title) VALUES ('�������������');

-- group
INSERT INTO public.study_group (title, speciality_id) VALUES ('��1', 7);