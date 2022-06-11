use biyi_test;
drop table user;
create table user(
    id int auto_increment,
    create_time varchar(20),
    name varchar(20),
    password varchar(36),
    phone varchar(20),
    nick_name varchar(20),
    primary key(id)
);

