create sequence hibernate_sequence start 3 increment 1;

create table usr (
id bigint not null,
user_name varchar(255) not null,
fio varchar(255),
email varchar(255) not null,
birth_date date,
sex varchar(255),
photo_url varchar(255),
primary key (id)
);


