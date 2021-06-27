-- run script in postgres: psql -U postgres -d Bikes_rental -a -f create_tables.sql
-- or in docker postgres container:  docker exec -i <db_name> mysql -u<user> -p<pswd> < create_tables.sql

drop table if exists bikes cascade;
drop table if exists booked_dates cascade;
drop table if exists users cascade;
drop table if exists orders cascade;
drop table if exists admins cascade;

create table bikes
(
    id SERIAL PRIMARY KEY,
    picture BYTEA,
    name VARCHAR(25),
    description VARCHAR(2000),
    price FLOAT8,
    type  VARCHAR(25),
    size VARCHAR(25),
    booked_dates JSON,
    reviews TEXT[],
    rating INT,
    gear TEXT[],
    status VARCHAR(25)
);

-- auto-generated definition
create table booked_dates
(
    id serial      not null
        constraint booked_dates_pk
            primary key,
    bike_id        integer
        constraint id_fkey
            references bikes,
    date_start     varchar(55) not null,
    date_end       varchar(55) not null
);

alter table booked_dates
    owner to postgres;

-- auto-generated definition
create table users
(
    id         serial not null
        constraint users_pk
            primary key,
    login      varchar(30),
    password   varchar(50),
    first_name varchar(30),
    last_name  varchar(50),
    email      varchar(50),
    phone      varchar(30),
    street     varchar(20),
    zip_code   varchar(10),
    city       varchar(30),
    country    varchar(20)
);

alter table users
    owner to postgres;

create unique index users_id_uindex
    on users (id);

-- auto-generated definition
create table orders
(
    id           serial  not null
        constraint orders_pk
            primary key,
    user_id    integer
        constraint id_fkey
            references users,
    booked_dates json
);

alter table orders
    owner to postgres;

create unique index orders_id_uindex
    on orders (id);

-- auto-generated definition
create table admins
(
    id       serial not null
        constraint admins_pk
            primary key,
    login    varchar(25),
    password varchar(55),
    email    varchar(55)
);

alter table admins
    owner to postgres;

create unique index admins_id_uindex
    on admins (id);

create unique index admins_login_uindex
    on admins (login);

INSERT INTO admins (id, login, password, email)
VALUES (0, 'admin', 'admin', 'iam@the.boss');

-- auto-generated definition
create table bike_details
(
    id     serial      not null
        constraint bike_details_pk
            primary key,
    name   varchar(11) not null,
    values text[]      not null
);

alter table bike_details
    owner to postgres;

create unique index bike_details_id_uindex
    on bike_details (id);



