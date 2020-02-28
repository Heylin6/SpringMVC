CREATE TABLE `order` (
	`orderid` BIGINT(20) NOT NULL,
	`createuser` VARCHAR(40) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`createtime` VARCHAR(13) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`status` VARCHAR(2) NULL DEFAULT '0' COLLATE 'utf8_unicode_ci',
	`memo` TEXT NULL DEFAULT 'none' COLLATE 'utf8_unicode_ci'
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
