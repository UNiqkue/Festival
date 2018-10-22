create table ev (
    id bigint(20) not null,
    name varchar(255) not null,
    description varchar(255) not null,
    data date not null,
    place varchar(255) not null,
    countPlace int,
    price decimal,
    primary key (id)
);

create table listOfUsers (
    id bigint(20) not null,
    list varchar(255),
    user_id bigint(20) not null,
    ev_id bitint(20) not null,
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (ev_id) REFERENCES ev (id)
);

create table listOfPerformer (
    id bigint(20) not null,
    list varchar(255),
    p_id bigint(20) not null,
    ev_id bitint(20) not null,
    FOREIGN KEY (p_id) REFERENCES performer (id),
    FOREIGN KEY (ev_id) REFERENCES ev (id)
);

create table ev_type (
    id bigint(20) not null,
    evtype varchar(255),
    ev_id bigint(20) not null,
    FOREIGN KEY (ev_id) REFERENCES ev (id)
);

create table user_role (
    id bigint(20) not null,
    roles varchar(255),
    user_id bigint(20) not null
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
    dateOfBirth date,
    cardNumber int(16),
    primary key (id)
);

create table performer (
    id bigint(20) not null,
    firstName varchar(255) not null,
    lastName varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255),
    activationCode varchar(255),
    phoneNumber varchar(255),
    dateOfBirth date,
    duration varchar(255),
    genre varchar(255),
    primary key (id)
);

alter table if exists ev
    add constraint ev_user_fk
    foreign key (user_id) references user(id);

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references user(id);
