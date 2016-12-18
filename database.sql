create table users (
user_id int not null AUTO_INCREMENT PRIMARY KEY,
user_type int,
password varchar(15),
u_email varchar(25),
uname varchar(20),
ulame varchar(20),
username varchar(20),
uaddress varchar(100)
);

ALTER TABLE users CHANGE first_name firstName varchar(30);
ALTER TABLE users CHANGE last_name  lastName varchar(30);
ALTER TABLE users CHANGE uaddress user_address varchar(200);

create table places (
place_id int not null,
place_name varchar(20),
constraint PK_places primary key (place_id));

create table cities (
city_id int not null,
city_name varchar(20),
constraint PK_cities primary key (city_id));



create table restaurants(
rid int NOT NULL,
rest_address varchar(100) ,
rest_name varchar(20),
owner_id int,
PRIMARY KEY (rid),
CONSTRAINT fk_owner FOREIGN KEY (owner_id) REFERENCES users(user_id));

insert into restaurants(rid,rest_address,rest_name,owner_id)
values(210,'Bagdat Caddesi','Sang Food House',3)

insert into restaurants(rid,rest_address,rest_name,owner_id)
values(211,'Kadikoy','Burger House',05)

insert into USERS(user_id,user_type,password ,u_email,firstName,lastName,username,user_address)
values (05,3,'1234','sedakozanoglu@hotmail.com','Seda','Kozanoglu','Sed','Atasehir bla sokak ');


create table orders(
order_id int NOT NULL,
rest_id int,
user_id int,
food_id int,
PRIMARY KEY (order_id),
constraint fk_rest foreign key(rest_id) references restaurants(rid),
constraint fk_user foreign key(user_id) references users(user_id))
constraint fk_food foreign key(food_,id) references rest_foods(food_type));

ALTER TABLE restaurants ADD rest_info varchar(300);
ALTER TABLE rest_foods MODIFY food_name varchar(100);

create table rest_foods (
rest_id int,
food_name varchar(20),
food_type varchar(20),
constraint fk_rest_food foreign key(rest_id) references restaurants(rid));

ALTER TABLE rest_foods CHANGE rest_id restaurant_id int;

select* from rest_foods

insert into rest_foods(restaurant_id,food_name,food_type,price)
values(2,'Arabiatta','Makarna','20TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(2,'Pesto Soslu Penne','Makarna','25TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(2,'Barbeku Soslu Tavuk','Et&Tavuk','30TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(2,'Akdeniz Pizza','Pizza','35TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(2,'Tantuni Pizza','Pizza','32TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(2,'Sezar Salata','Salata','27TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(2,'Brownie Cheessecake','Tatli','17TL');


insert into rest_foods(restaurant_id,food_name,food_type,price)
values(4,'Cafe de Paris Soslu Et','Et&Tavuk','45TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(4,'Fajita','Et&Tavuk','32TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(4,'Patates Tava','Baslangic','12TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(4,'Sosis Tava','Baslangic','13TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(4,'Kori Soslu Tavuk','Et&Tavuk','22TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(4,'Su','Icecek','3TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(4,'Coca Cola','Icecek','5TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(4,'Ayran','Icecek','5TL');
insert into rest_foods(restaurant_id,food_name,food_type,price)
values(4,'Portakal Suyu','Icecek','7TL');


select food_name from rest_foods where restaurant_id=211;

create table rest_status(
rid int not null,
rest_name varchar(100),



create table user_types(
type_no int,
type_name varchar(20),
type_id int,
constraint fk_type foreign key(type_id) references users(user_id));

ALTER TABLE users MODIFY u_email varchar(200);

select * from users
select* from user_types

insert into cities (city_id,city_name)
values (35,'Izmir');
insert into cities (city_id,city_name)
values (34,'Istanbul');
insert into cities (city_id,city_name)
values (06,'Ankara');
insert into cities (city_id,city_name)
values (07,'Antalya');
insert into cities (city_id,city_name)
values (41,'Kocaeli');
insert into cities (city_id,city_name)
values (16,'Bursa');
insert into cities (city_id,city_name)
values (01,'Adana');

select * from cities;
select* from places;
select* from restaurants;

insert into USERS(user_id,user_type,password ,u_email,uname,ulame,username,uaddress)
values (01,1,'1234','selenkozanoglu@gmail.com','selen','kozanoglu','selo','sırmakeş sok. ömer amca apt. 15/7');

insert into USERS(user_id,user_type,password ,u_email,uname,ulame,username,uaddress)
values (02,2,'1234','nazliakdagu@gmail.com','nazli','akdag','user12','bla bla ');

insert into USERS(user_id,user_type,password ,u_email,uname,ulame,username,uaddress)
values (03,3,'1234','blaaa','user1','Aysenaz','Aydemir','bla bla 123 ');

insert into USERS(user_type,password ,u_email,firstName,lastName,username,user_address,usrtel)
values ('3','1234','aysenazaydemir@hotmail.com','Aysenaz','Aydemir','Aysenaz','Erenkoy','055334545');

insert into USERS(user_type,password ,u_email,firstName,lastName,username,user_address,usrtel)
values ('2','1234','nazliakdag@hotmail.com','Nazli','Akdag','Nazli','Izmit','053221445');

insert into USERS(user_type,password ,u_email,firstName,lastName,username,user_address,usrtel)
values ('3','1234','gamzesarac@hotmail.com','Gamze','Sarac','Gamze','Cekmekoy','05645476');

insert into USERS(user_type,password ,u_email,firstName,lastName,username,user_address,usrtel)
values ('3','1234','busraefe@hotmail.com','Busra','Efe','Busra','Cengelkoy','05677859');

insert into USERS(user_type,password ,u_email,firstName,lastName,username,user_address,usrtel)
values ('3','1234','gulenaycetinkaya@hotmail.com','Gulenay','Cetinkaya','Gulenay','Izmit','05324674251');

values (04,4,'1234','blaa','user92','Gamze','Sarac','lalaa 123 ');

delete from users where uname='Aysenaz';
delete from users where uname='Gamze';


insert into  user_types(type_no,type_name,type_id)
values (01,'Customer',1);

insert into  user_types(type_no,type_name,type_id)
values (02,'Manager',2);

insert into  user_types(type_no,type_name,type_id)
values (03,'Restaurant Owner',3);

insert into  user_types(type_no,type_name,type_id)
values (04,'Admin',4);

insert into restaurants (rid,rest_address,rest_name,owner_id)
values (111,'Caddebostan','Midpoint',01)

insert into orders (order_id,rest_id,user_id,food_id,food_name)
values (1,4,1,1,'Fajita')

select* from rest_foods
select * from user_types
select * from restaurants
select* from orders

ALTER TABLE orders
ADD food_name Varchar(200);



alter table users AUTO_INCREMENT =1