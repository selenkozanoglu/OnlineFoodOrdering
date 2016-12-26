create database sangFood;
use sangFood;


create table users (
user_id int not null AUTO_INCREMENT PRIMARY KEY,
username varchar(50) unique,
user_type int,
password varchar(30),
firstName varchar(50),
lastName varchar(50),
u_email varchar(100),
username varchar(200),
user_address varchar(300),
usrtel varchar(100),
constraint PK_customers primary key (user_id));

create table orders(
order_id int NOT NULL  AUTO_INCREMENT PRIMARY KEY,
rest_id int,
user_id varchar(50),
food_id int,
order_sum varchar(50),
constraint fk_rest foreign key(rest_id) references restaurants(rid),
constraint fk_user foreign key(user_id) references users(username));

create table user_types(
type_no int,
type_name varchar(20),
type_id int,
constraint fk_type foreign key(type_id) references users(user_id));

create table restaurants(
rid int not null AUTO_INCREMENT PRIMARY KEY,
rest_address varchar(100) ,
rest_name varchar(20),
owner_id int,
CONSTRAINT fk_owner FOREIGN KEY (owner_id) REFERENCES users(user_id));

create table rest_foods (
restaurant_id int,
food_name varchar(20),
food_type varchar(20),
constraint fk_rest_food foreign key(restaurant_id) references restaurants(rid));

create table places (
place_id int not null,
place_name varchar(20),
constraint PK_places primary key (place_id));

create table cities (
city_id int not null,
city_name varchar(20),
constraint PK_cities primary key (city_id));

create table order_status(
status_id int,
status_name varchar(20)
);

insert into order_status (status_id,status_name)
values (0, 'order is waiting');

insert into order_status (status_id,status_name)
values (1, 'order deliveried');

alter table orders  modify column order_date timestamp

alter table orders add order_status int
