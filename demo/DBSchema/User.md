CREATE TABLE `user` (
	`userid` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(20) NOT NULL COLLATE 'utf8_unicode_ci',
	`password` VARCHAR(300) NOT NULL DEFAULT '0',
	`createtime` VARCHAR(13) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`status` VARCHAR(2) NULL DEFAULT '0' COLLATE 'utf8_unicode_ci',
	PRIMARY KEY (`userid`),
	UNIQUE INDEX `username` (`username`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
