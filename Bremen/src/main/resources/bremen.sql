CREATE DATABASE IF NOT EXISTS BREMEN;

USE BREMEN;

CREATE TABLE IF NOT EXISTS `user`(
	`userId` varchar(50) NOT NULL,
    `userPassword` varchar(16) NOT NULL,
    `userName` varchar(10) NOT NULL,
    `userNickname` varchar(10) NOT NULL,
    `userPoint` int DEFAULT 0,
    `userFriend` varchar(10) DEFAULT 0,
    PRIMARY KEY (userId)
)ENGINE = InnoDB;

insert into user
values
("ssafy", "1234", "복광열", "복싸피", 0, NULL),
("gunsanking", "12345", "김군산", "군산왕", 0, NULL);

select * from user;

CREATE TABLE IF NOT EXISTS `board`(
	`boardId` int NOT NULL,
    `boardTitle` varchar(50) NOT NULL,
    `boardContent` text NOT NULL,
    `boardWriter` varchar(50) NOT NULL,
    `boardViewCnt` int DEFAULT 0,
    `boardRegDate` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `boardCategory` varchar(20) NOT NULL,
    `boardLike` int DEFAULT 0,
    `boardHate` int DEFAULT 0,
    PRIMARY KEY (boardId),
    FOREIGN KEY (boardWriter) References user (userID)
)engine = InnoDB;

CREATE table if not exists `review`(
	`reviewContent` text not null,
    `reviewWriter` varchar(50) not null,
    `reviewLike` int default 0,
    `reviewId` int not null,
    `postId` int not null,
    primary key (reviewId),
    foreign key (postId) references board (boardId)
)engine = InnoDB;
