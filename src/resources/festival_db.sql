create table performer (
    id bigint(20) not null AUTO_INCREMENT,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    age int(11),
    username varchar(255),
    password varchar(255),
    email varchar(255),
    activationCode varchar(255),
    phoneNumber varchar(255),
    duration varchar(255),
    genre varchar(255),
    primary key (id)
);

create table user (
    id bigint(20) not null AUTO_INCREMENT,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    age int(11),
    username varchar(255),
    password varchar(255),
    email varchar(255),
    activationCode varchar(255),
    phoneNumber varchar(255),
    cardNumber int(16),
    primary key (id)
);

create table fest (
    id bigint(20) not null AUTO_INCREMENT,
    name varchar(255) not null,
    description varchar(255),
    countPlace int,
    price float,
    primary key (id)
);

create table fest_type (
    type varchar(255),
    fest_id bigint(20) not null
);

create table user_role (
    role varchar(255),
    user_id bigint(20) not null
);

create table listOfUsers (
    id bigint(20) not null AUTO_INCREMENT,
    list varchar(255),
    user_id bigint(20) not null,
    fest_id bigint(20) not null,
    primary key (id)
);

create table listOfPerformer (
    id bigint(20) not null AUTO_INCREMENT,
    list varchar(255),
    p_id bigint(20) not null,
    fest_id bigint(20) not null,
    primary key (id)
);

alter table listOfUsers add foreign key(user_id) references user(id);

alter table listOfUsers add foreign key(fest_id) references fest(id);

alter table listOfPerformer add foreign key(p_id) references performer(id);

alter table listOfPerformer add foreign key(fest_id) references fest(id);

alter table user_role add foreign key(user_id) references user(id);

alter table fest_type add foreign key(fest_id) references fest(id);


Insert into user(firstname, lastname) values("Andrew", "Garfild");
Insert into user(firstname, lastname) values("Иван", "Мирошко");
Insert into user(firstname, lastname) values("Артём", "Чудо");
Update user set age=24;
Insert into user(firstname, lastname, age) values("Артём", "Чудо", 17);

Insert into fest(name, description, countplace, price) values("ClassiFest", "Фестиваль классической музыки", 120, 17.0);
Insert into fest_type(type, fest_id) values("MUSIC_FESTIVAL", 1);
Insert into performer(firstname, lastname, age, genre) values("Владислав", "Бакей", 23, "rap");
Insert into listofperformer(id, list, p_id, fest_id) values(1, NULL, 1, 1);