-- liquibase formatted sql

-- changeset tgusainov:1
create table if not exists ingredients (
    id serial primary key,
    name varchar(25) not null,
    type varchar(10) not null
);
create table if not exists tacos (
    id serial primary key,
    name varchar(50) not null,
    create_at timestamp not null
);
create table if not exists taco_orders (
    id serial primary key,
    name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state varchar(20) not null,
    zip varchar(10) not null,
    ccNumber varchar(16) not null,
    ccExpiration varchar(5) not null,
    ccCVV varchar(3) not null,
    placed_at timestamp not null
);
create table if not exists users (
    id serial primary key,
    username varchar(50) not null,
    password varchar(50) not null,
    fullName varchar(50),
    street varchar(50),
    city varchar(50),
    state varchar(20),
    zip varchar(10),
    phoneNumber varchar(12)
);

-- changeset tgusainov:2

insert into ingredients (id, name, type) values (1, 'Flour Tortilla', 'WRAP');
insert into ingredients (id, name, type) values (2, 'Corn Tortilla', 'WRAP');
insert into ingredients (id, name, type) values (3, 'Ground Beef', 'PROTEIN');
insert into ingredients (id, name, type) values (4, 'Carnitas', 'PROTEIN');
insert into ingredients (id, name, type) values (5, 'Diced Tomatoes', 'VEGGIES');
insert into ingredients (id, name, type) values (6, 'Lettuce', 'VEGGIES');
insert into ingredients (id, name, type) values (7, 'Cheddar', 'CHEESE');
insert into ingredients (id, name, type) values (8, 'Monterrey Jack', 'CHEESE');
insert into ingredients (id, name, type) values (9, 'Salsa', 'SAUCE');
insert into ingredients (id, name, type) values (10, 'Sour Cream', 'SAUCE');