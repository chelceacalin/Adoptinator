create table message_entity
(
    id          uuid not null primary key,
    message     varchar(255),
    to_whom     uuid constraint fk_target_user_id references user_entity,
    who_sent_it uuid constraint fk_current_user_id references user_entity
);

create table friendship_entity
(
    id        uuid not null   primary key,
    message   varchar(255),
    status    varchar(255) constraint friendship_entity_status_check check ((status)::text = ANY
                   ((ARRAY ['REQUEST_SENT'::character varying, 'FRIENDS'::character varying, 'REQUEST_CANCELLED'::character varying])::text[])),
    user_1_id uuid constraint fk_user_1_id references user_entity,
    user_2_id uuid constraint fk_user_2_id references user_entity
);

create table comment_entity
(
    id                uuid not null  primary key,
    message           varchar(255),
    send_date         date,
    parent_comment_id uuid  constraint fk_parent_comm_id  references comment_entity,
    post_id           uuid constraint fk_post_id  references post_entity
);

