create schema if not exists ssafit ;
use ssafit;

DROP TABLE IF EXISTS comment cascade ;
DROP TABLE IF EXISTS board cascade;
DROP TABLE IF EXISTS users cascade;

CREATE TABLE IF NOT EXISTS users (
                       user_id VARCHAR(255) PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       address VARCHAR(255),
                       authority INT default 1,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       salt VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS board (
                       board_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       user_id VARCHAR(255) NOT NULL,
                       current_update TIMESTAMP default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       subject VARCHAR(255) NOT NULL,
                       content VARCHAR(255) NOT NULL,
                       hit INT DEFAULT 0,
                       type VARCHAR(255) default 'COMMUNITY'
);

create table IF NOT EXISTS Comment(
                         comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         user_id VARCHAR(255) NOT NULL,
                         board_id BIGINT NOT NULL,
                         content VARCHAR(255) NOT NULL,
                         current_update TIMESTAMP  default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


