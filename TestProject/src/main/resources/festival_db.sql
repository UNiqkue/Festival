create table performer (
    id bigint(20) not null AUTO_INCREMENT,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    age int(11) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    activationCode varchar(255),
    duration varchar(255),
    genre varchar(255),
    primary key (id)
);

create table user (
    id bigint(20) not null AUTO_INCREMENT,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    age int(11) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    activationCode varchar(255),
    phoneNumber varchar(255),
    cardNumber int(16),
    primary key (id)
);

create table fest (
    id bigint(20) not null AUTO_INCREMENT,
    name varchar(255) not null,
    description varchar(255) not null,
    countPlace int not null,
    price float not null,
    primary key (id)
);

create table fest_type (
    type varchar(255) not null,
    fest_id bigint(20) not null
);

create table user_role (
    role varchar(255) not null,
    user_id bigint(20) not null
);

create table listOfUsers (
    user_id bigint(20) not null,
    fest_id bigint(20) not null
);

create table listOfPerformer (
    p_id bigint(20) not null,
    fest_id bigint(20) not null
);

alter table listOfUsers add foreign key(user_id) references user(id);

alter table listOfUsers add foreign key(fest_id) references fest(id);

alter table listOfPerformer add foreign key(p_id) references performer(id);

alter table listOfPerformer add foreign key(fest_id) references fest(id);

alter table user_role add foreign key(user_id) references user(id);

alter table fest_type add foreign key(fest_id) references fest(id);
