CREATE TABLE `member` (
	`mid` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`account` VARCHAR(50) NOT NULL,
	`password` VARCHAR(100) NOT NULL COLLATE 'utf8_unicode_ci',
	`createTime` VARCHAR(13) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`modifyTime` VARCHAR(13) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`createMid` VARCHAR(40) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`modifyMid` VARCHAR(40) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`status` VARCHAR(2) NULL DEFAULT '1' COLLATE 'utf8_unicode_ci',
	PRIMARY KEY (`mid`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;


CREATE TABLE `user` (
	`userId` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`userName` VARCHAR(40) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`createTime` VARCHAR(13) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`userStatus` VARCHAR(2) NULL DEFAULT '0' COLLATE 'utf8_unicode_ci',
	PRIMARY KEY (`userId`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;



CREATE TABLE `order` (
	`OrderId` BIGINT(20) NOT NULL,
	`createMember` VARCHAR(40) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`createTime` VARCHAR(13) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`status` VARCHAR(2) NULL DEFAULT '0' COLLATE 'utf8_unicode_ci'
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
