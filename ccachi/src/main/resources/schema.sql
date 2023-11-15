DROP TABLE IF EXISTS comment cascade ;
DROP TABLE IF EXISTS board cascade;
DROP TABLE IF EXISTS ccachiuser cascade;

create table ccachiuser
(
    id              bigint primary key auto_increment,
    email           varchar(50) not null unique,
    password             varchar(50) not null,
    name            varchar(50) not null,
    created_at      timestamp   not null default now()
);

create table board
(
    id            bigint primary key auto_increment,
    contents       varchar(255) not null,
    title       varchar(127) not null,
    comment_count bigint       not null default 0 check (comment_count >= 0),
    created_at    timestamp    not null default now(),
    user_id     bigint       not null,
    FOREIGN KEY (user_id) REFERENCES ccachiuser(id) on update cascade on delete cascade
);

create table comment
(
    id         bigint primary key auto_increment,
    content    varchar(127) not null,
    created_at timestamp    not null default now(),
    board_id  bigint       not null,
    user_id  bigint       not null,
    FOREIGN KEY (user_id) REFERENCES ccachiuser(id) on update cascade on delete cascade,
    FOREIGN KEY (board_id) REFERENCES board(id) on update cascade on delete cascade
);