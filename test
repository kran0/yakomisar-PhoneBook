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

INSERT INTO employee(id, email, first_name, phone, second_name, workplace)
VALUES (1, 'ivan@corp.ru', 'Ivan', '495-780-30-45', 'Zolotov', 'Google'),
       (2, 'sergey@mail.ru', 'Sergey', '495-241-29-45', 'Potemkin', 'IBM'),
       (3, 'stepan@sber.ru', 'Stepan', '345-101-33-44', 'Dubinin', 'Sberbank'),
       (4, 'oleg@alfa.ru', 'Oleg', '495-780-30-45', 'Kanarin', 'AlfaCapital'),
       (5, 'sergey@mag.ru', 'Sergey', '495-780-30-45', 'Mostovitskiy', 'Magnit'),
       (6, 'masha@mts.ru', 'Maria', '495-780-30-45', 'Aleshina', 'MTS'),
       (7, 'elena@bline.ru', 'Elena', '495-780-30-45', 'Dorozhnaya', 'Beeline'),
       (8, 'andrey@cola.ru', 'Andrey', '495-780-30-45', 'Stepanov', 'Coca-Cola'),
       (9, 'anton@ya.ru', 'Anton', '495-780-30-45', 'Pulatov', 'Yandex'),
       (10, 'vitya@mcd.ru', 'Viktor', '495-780-30-45', 'Plushkin', 'McDonalds');