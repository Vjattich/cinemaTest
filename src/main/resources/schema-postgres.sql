DROP TABLE IF EXISTS film, session, ticket;
DROP SEQUENCE IF EXISTS film_id_seq, session_id_seq, ticket_id_seq;

create sequence film_id_seq
  as integer
  maxvalue 2147483647;

alter sequence film_id_seq owner to postgres;

create table film
(
  id          serial       not null
    constraint film_pkey primary key,
  description varchar(255),
  genre       varchar(255) not null,
  name        varchar(255) not null,
  popularity  integer
);

alter table film
  owner to postgres;


create sequence session_id_seq
  as integer
  maxvalue 2147483647;

alter sequence session_id_seq owner to postgres;

create table session
(
  id      serial not null
    constraint session_pkey primary key,
  city    varchar(255),
  date    timestamp,
  film_id integer
    constraint fkkkn7xyoyaofuwom5dqmf8bg90 references film
);

alter table session
  owner to postgres;

create sequence ticket_id_seq
  as integer
  maxvalue 2147483647;

alter sequence ticket_id_seq owner to postgres;

create table ticket
(
  id                 serial       not null
    constraint ticket_pkey primary key,
  owner_email        varchar(255) not null,
  owner_phone_number varchar(255) not null,
  place              integer      not null,
  creation_date      timestamp    not null,
  session_id         integer
    constraint fk5x0dvk4itqbdpu2dxdo02b5f7 references session
);

alter table ticket
  owner to postgres;
