drop table tp;
drop table topics;
drop table forum;
drop table session;

create table tp(
id int,
name varchar(300),
message varchar(300),
date timestamp
);

create table topics(
id integer auto_increment primary key,
topic varchar(200),
author varchar(200),
date timestamp,
content varchar(8000),
subid int
);

create table forum(
id integer auto_increment primary key,
forum varchar(200),
topics varchar(200),
subid int
); 

create table session(
user varchar(200),
username varchar(200),
password varchar(200)
); 

insert into session values ('John Doe', 'jdoe1','abcd');
insert into session values ('Jane Doe', 'jdoe2','abcd');
