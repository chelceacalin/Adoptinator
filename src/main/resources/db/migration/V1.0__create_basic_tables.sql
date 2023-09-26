create table user_entity
(
    id        uuid not null
        primary key,
    password  varchar(255),
    photo_url varchar(255),
    username  varchar(255)
);

create table post_entity
(
    id           uuid not null constraint post_entity_pkey primary key,
    created_date date,
    description  varchar(255),
    photo_url    varchar(255),
    title        varchar(255),
    user_id      uuid  constraint fk_user_id references user_entity
);

create table like_entity
(
    id      uuid not null constraint like_entity_pkey  primary key,
    post_id uuid constraint fk_post_id references post_entity,
    user_id uuid  constraint fk_user_id references user_entity
);

