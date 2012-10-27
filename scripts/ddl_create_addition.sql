drop table params;
drop table user_roles;
drop table users;

create table params (
    pkey varchar(15)    unique not null,
    pvalue varchar(50) 
);

create table users (
    id int not null,
    person_id int,
    login varchar(20) unique not null,
    password varchar(30) not null,
    enabled int,
    primary key (id)
);

create table user_roles (
    user_id     int     not null,
    authority 	varchar(45)    not null,
    foreign key (user_id) references users (id) on delete cascade on update cascade
);