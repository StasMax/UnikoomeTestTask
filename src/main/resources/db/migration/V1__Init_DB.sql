create sequence hibernate_sequence start 3 increment 1;

create table usr (
id bigint not null,
user_name varchar(255) not null,
fio varchar(255),
email varchar(255) not null,
birth_date date,
sex varchar(255),
photo_url varchar(255),
primary key (id),
constraint user_name_const UNIQUE (user_name),
constraint user_email_const UNIQUE (email)
);


