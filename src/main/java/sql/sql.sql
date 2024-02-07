create table if not exists admin(
    admin_id serial primary key ,
    username varchar(255),
    password varchar(255)
);

create table if not exists users(
    user_id serial primary key ,
    username varchar(255),
    password varchar(255)
);

create table if not exists category(
    category_id serial primary key ,
    category_name varchar(255)
);

create table if not exists product(
    product_id serial primary key ,
    product_name varchar(255),
    category_id_fk int references category(category_id)
);
create table if not exists cart(
    cart_id serial primary key ,
    product_id_fk int references product(product_id),
    count int,
    total_price int
);
