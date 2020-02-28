CREATE TABLE `member` (
	`mid` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`account` VARCHAR(50) NOT NULL,
	`password` VARCHAR(200) NOT NULL COLLATE 'utf8_unicode_ci',
	`createtime` VARCHAR(13) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`modifytime` VARCHAR(13) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`createmid` VARCHAR(40) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`modifymid` VARCHAR(40) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`status` VARCHAR(2) NULL DEFAULT '1' COLLATE 'utf8_unicode_ci',
	`lastlogintime` VARCHAR(13) NULL DEFAULT NULL,
	PRIMARY KEY (`mid`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;
