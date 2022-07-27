create sequence hibernate_sequence start 1 increment 1;

create table codes (
    id int4 not null,
    code varchar(255),
    primary key (id)
);

create table employee (
    id int4 not null,
    email varchar(255),
    first_name varchar(255),
    phone varchar(255),
    second_name varchar(255),
    workplace varchar(255),
    primary key (id)
);

INSERT INTO codes(id, code)
VALUES (1, '495'),
       (2, '345'),
       (3, '789'),
       (4, '123'),
       (5, '890'),
       (6, '007'),
       (7, '015');