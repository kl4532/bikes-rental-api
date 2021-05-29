-- run script in postgres: psql -U postgres -d Bikes_rental -a -f create_tables.sql
-- or in docker postgres container:  docker exec -i <db_name> mysql -u<user> -p<pswd> < create_tables.sql

drop table if exists bikes;
drop table if exists booked_dates;
drop table if exists bikes_booked_dates;

create table bikes
(
    id SERIAL PRIMARY KEY,
    picture BYTEA,
    name VARCHAR(25),
    description VARCHAR(2000),
    price FLOAT8,
    type  VARCHAR(25),
    size VARCHAR(25),
    booked_dates JSON, -- maybe this type is not correct??
    reviews TEXT[],
    rating INT,
    gear TEXT[],
    status VARCHAR(25)
);

create table booked_dates
(
    booked_date_id serial      not null
        constraint booked_dates_pk
            primary key,
    date_start     varchar(55) not null,
    date_end       varchar(55) not null,
    bike_id        integer     not null
        constraint id_fkey
            references bikes
);

alter table booked_dates
    owner to postgres;


-- create table bikes_booked_dates
-- (
--     bike_id        integer not null
--         constraint bikes_booked_dates_bike_id_fkey
--             references bikes,
--     booked_date_id integer not null
--         constraint bikes_booked_dates_booked_date_id_fkey
--             references booked_dates
-- );

-- alter table bikes_booked_dates
--     owner to postgres;

-- create unique index bikes_booked_dates_id_uindex
--     on booked_dates (booked_date_id);





