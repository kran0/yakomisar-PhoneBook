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
VALUES (101, 'ivan@corp.ru', 'Ivan', '495-780-30-45', 'Zolotov', 'Google'),
       (102, 'sergey@mail.ru', 'Sergey', '495-241-29-45', 'Potemkin', 'IBM'),
       (103, 'stepan@sber.ru', 'Stepan', '345-101-33-44', 'Dubinin', 'Sberbank'),
       (104, 'oleg@alfa.ru', 'Oleg', '495-780-30-45', 'Kanarin', 'AlfaCapital'),
       (105, 'sergey@mag.ru', 'Sergey', '495-780-30-45', 'Mostovitskiy', 'Magnit'),
       (106, 'masha@mts.ru', 'Maria', '495-780-30-45', 'Aleshina', 'MTS'),
       (107, 'elena@bline.ru', 'Elena', '495-780-30-45', 'Dorozhnaya', 'Beeline'),
       (108, 'andrey@cola.ru', 'Andrey', '495-780-30-45', 'Stepanov', 'Coca-Cola'),
       (109, 'anton@ya.ru', 'Anton', '495-780-30-45', 'Pulatov', 'Yandex'),
       (110, 'vitya@mcd.ru', 'Viktor', '495-780-30-45', 'Plushkin', 'McDonalds');