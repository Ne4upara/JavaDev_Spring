create sequence authorities_id_seq start with 1;

create table users
(
    username varchar(50)  not null primary key,
    enabled  boolean      not null,
    password varchar(500) not null
);

create table authorities
(
    id        bigint default nextval('authorities_id_seq'::regclass) not null primary key,
    authority varchar(50)                                            not null,
    username  varchar(50)                                            not null,
    constraint fkhjuy9y4fd8v5m3klig05ktofg foreign key (username) references users,
    constraint ix_auth_username unique (username, authority)
);