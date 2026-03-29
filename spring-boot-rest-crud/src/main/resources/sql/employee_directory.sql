create database if not exists `employee_directory`;
use `employee_directory`;

drop table if exists `employee`;
create table `employee` (
	`id` int not null auto_increment,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `email` varchar(45) default null,
    primary key (`id`)
) engine=InnoDB auto_increment=1 default charset=latin1;