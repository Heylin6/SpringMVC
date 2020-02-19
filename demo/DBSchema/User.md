CREATE TABLE `user` (
	`userId` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(40) NOT NULL COLLATE 'utf8_unicode_ci',
	`password` VARCHAR(100) NOT NULL DEFAULT '0',
	`createtime` VARCHAR(13) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`userstatus` VARCHAR(2) NULL DEFAULT '0' COLLATE 'utf8_unicode_ci',
	PRIMARY KEY (`userId`),
	UNIQUE INDEX `username` (`username`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
