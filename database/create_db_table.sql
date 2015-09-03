-- create db
create database profilemanager;

-- create tables
create table `group` (
	id int(20),
	name varchar(100),
	PRIMARY KEY (id)
);

create table user (
	id int(20) primary key,
	name varchar(100),
	email varchar(100),
	group_id int(20),
	FOREIGN KEY (group_id) REFERENCES `group`(id)
);

create table user_group (
	user_id int(20),
	group_id int(20)
);

