create table users
(
    id       bigint not null
        primary key,
    password varchar(60) not null ,
    role     varchar(10) not null ,
    username varchar(60) not null
        constraint uk_r3xwopo6ga2sm1606e4hervd0
            unique
);

alter table users
    owner to admin;

create sequence useridgenerator;

alter sequence useridgenerator owner to admin;