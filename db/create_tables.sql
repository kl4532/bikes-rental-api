-- run script in postgres: psql -U postgres -d Bikes_rental -a -f create_tables.sql
-- or in docker postgres container:  docker exec -i <db_name> mysql -u<user> -p<pswd> < create_tables.sql

drop table if exists bikes cascade;
drop table if exists booked_dates cascade;
drop table if exists users cascade;
drop table if exists orders cascade;

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





