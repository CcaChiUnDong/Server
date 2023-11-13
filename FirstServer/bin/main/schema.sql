-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafit` DEFAULT CHARACTER SET utf8;
USE `ssafit`;

-- -----------------------------------------------------
-- Table `ssafit`.`video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`video`
(
    `videoId`   INT         NOT NULL AUTO_INCREMENT,
    `title`     VARCHAR(45) NOT NULL,
    `videoURL`  VARCHAR(45) NOT NULL,
    `category`  VARCHAR(45) NOT NULL,
    `viewCount` INT         NOT NULL,
    `uploader`  VARCHAR(45) NOT NULL,
    PRIMARY KEY (`videoId`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafit`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`user`
(
    `num`      INT         NOT NULL AUTO_INCREMENT,
    `userId`   VARCHAR(20) NOT NULL,
    `password` VARCHAR(20) NOT NULL,
    `name`     VARCHAR(45) NOT NULL,
    `phone`    VARCHAR(13) NOT NULL,
    `email`    VARCHAR(45) NOT NULL,
    `grade`    VARCHAR(10) NOT NULL,
    PRIMARY KEY (`num`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafit`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`review`
(
    `reviewId`      INT         NOT NULL AUTO_INCREMENT,
    `title`         VARCHAR(45) NOT NULL,
    `content`       VARCHAR(45) NOT NULL,
    `regDate`       DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `viewCnt`       INT         NOT NULL,
    `videoReviewId` INT         NOT NULL,
    `writer`        VARCHAR(20) NOT NULL,
    PRIMARY KEY (`reviewId`, `videoReviewId`, `writer`),
    INDEX `fk_review_video_idx` (`videoReviewId` ASC) VISIBLE,
    INDEX `fk_review_user1_idx` (`writer` ASC) VISIBLE,
    CONSTRAINT `fk_review_video`
        FOREIGN KEY (`videoReviewId`)
            REFERENCES `ssafit`.`video` (`videoId`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_review_user1`
        FOREIGN KEY (`writer`)
            REFERENCES `ssafit`.`user` (`name`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `ssafit`.`board`
(
    `b_id`           INT          NOT NULL AUTO_INCREMENT,
    `b_writer`       VARCHAR(100) NOT NULL,
    `b_title`        VARCHAR(100) NOT NULL,
    `b_contents`     TEXT         NOT NULL,
    `b_created_date` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `b_update_date`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`b_id`)
) ENGINE = InnoDB;

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

insert into board (b_id, b_writer, b_title, b_contents)
VALUES
    (0, 'writer1','title1', 'context1'),
    (0, 'writer1','title2', 'context2'),
    (0, 'writer2','title3', 'context3');
# insert into video(videoId, category, videoURL, uploader, viewCount, title)
# VALUES
#     (1,'전신','https://www.youtube.com/embed/gMaB-fG4u4g','ThankyouBUBU',0, '제목1'),
#     (2,'전신','https://www.youtube.com/embed/swRNeYw1JkY','ThankyouBUBU',0, '제목2'),
#     (3,'상체','https://www.youtube.com/embed/54tTYO-vU2E','ThankyouBUBU',0, '제목3'),
#     (4,'상체','https://www.youtube.com/embed/QqqZH3j_vH0','ThankyouBUBU',0, '제목4'),
#     (5,'하체','https://www.youtube.com/embed/tzN6ypk6Sps','김강민',0, '제목5'),
#     (6,'하체','https://www.youtube.com/embed/u5OgcZdNbMo','GYM종국',0, '제목6'),
#     (7,'복부','https://www.youtube.com/embed/PjGcOP-TQPE','ThankyouBUBU',0, '제목7'),
#     (8,'복부','https://www.youtube.com/embed/7TLk7pscICk','SomiFit',0, '제목8');

# insert into user (num, userId, password, name, phone, email, grade)
# VALUES
#     (1, 'ssafy','1234','ssafy','010-1234-1234', 'ssafit@ssafit', 'VIP'),
#     (2, 'ssafy2', '1234','ssafy2','010-1234-1234', 'ssafit@ssafit', 'BASIC');

# insert into review (reviewId, title, content, viewCnt, videoReviewId, writer)
# VALUES (0, 'review1', 'content1', 0, 1, 'ssafy'),
#        (0, 'review2', 'content2', 0, 3, 'ssafy'),
#        (0, 'review3', 'content3', 0, 1, 'ssafy2'),
#        (0, 'review4', 'content4', 0, 2, 'ssafy2')