create table note
(
    id      bigint not null
        primary key,
    content varchar(255),
    title   varchar(255)
);

alter table note
    owner to admin;

create sequence noteidgenerator
    start with 1;

alter sequence noteidgenerator owner to admin;