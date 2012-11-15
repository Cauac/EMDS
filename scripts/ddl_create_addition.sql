drop table params;
-- drop table user_role;
drop table users;
drop table roles;


create table params (
    pkey varchar(15)    unique not null,
    pvalue varchar(300) 
);


create table roles(
    id serial,
    authority varchar(45) not null,
    primary key (id)
);

create table users (
    id serial,
    person_id bigint,
    person_type varchar(10),
    role_id int,
    login varchar(20) unique not null,
    password varchar(32) not null,
    enabled int,
    primary key (id),
    foreign key (role_id) references roles(id) on delete no action on update cascade
);


-- create table user_role(
--     user_id	int not null,
--     role_id	int not null,
--     primary key (user_id, role_id),
--     foreign key (user_id) references users(id) on delete cascade on update cascade,
--     foreign key (role_id) references roles(id) on delete cascade on update cascade
-- );