create table products (
    id varchar(7) primary key,
    name varchar(50) not null,
    description varchar(255),
    price numeric(18, 2)
);