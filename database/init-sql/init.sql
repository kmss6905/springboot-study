CREATE DATABASE IF NOT EXISTS firstDB; CREATE DATABASE IF NOT EXISTS secondDB;

create table team(
    id long auto_increment primary key,
    team_name varchar(100) not null,
    created datetime not null default now()
);

create table member (
    id long auto_increment primary key,
    name varchar(100) not null,
    age int(10) unsigned not null,
    sex char(1) not null,
    team_id int(11),
    foreign key (team_id) references team(id)
);

insert member(name, age, sex) values ('민식', 21, 'M'), ('지수', 22, 'W')