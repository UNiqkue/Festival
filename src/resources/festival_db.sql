create table performer (
    id bigint(20) not null,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255),
    activationCode varchar(255),
    phoneNumber varchar(255),
    age int(11),
    duration varchar(255),
    genre varchar(255),
    primary key (id)
);

create table user (
    id bigint(20) not null,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255),
    activationCode varchar(255),
    phoneNumber varchar(255),
    age int(11),
    cardNumber int(16),
    primary key (id)
);

create table fest (
    id bigint(20) not null,
    name varchar(255) not null,
    description varchar(255) not null,
    countPlace int,
    price float,
    primary key (id)
);

create table fest_type (
    evtype varchar(255),
    fest_id bigint(20) not null
);

create table user_role (
    role varchar(255),
    user_id bigint(20) not null
);

create table listOfUsers (
    id bigint(20) not null,
    list varchar(255),
    user_id bigint(20) not null,
    fest_id bigint(20) not null,
    primary key (id)
);

create table listOfPerformer (
    id bigint(20) not null,
    list varchar(255),
    p_id bigint(20) not null,
    fest_id bigint(20) not null,
    primary key (id)
);

alter table listOfUsers add foreign key(user_id) references festival(id);

alter table listOfUsers add foreign key(fest_id) references festival(id);

alter table listOfPerformer add foreign key(p_id) references performer(id);

alter table listOfPerformer add foreign key(fest_id) references festival(id);

alter table user_role add foreign key(user_id) references user(id);

alter table fest_type add foreign key(fest_id) references user(id);
