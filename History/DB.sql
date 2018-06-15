
1. 테이블 생성
	# tb_code
	CREATE TABLE `tb_code` (
	  `CD_DO` VARCHAR(3) NOT NULL COMMENT '도메인',
	  `CD_UP` VARCHAR(4) NOT NULL COMMENT '상위코드',
	  `CD_DN` VARCHAR(5) NOT NULL COMMENT '하위코드',
	  `CD_KOR` VARCHAR(50) NOT NULL COMMENT '한글코드명',
	  `CD_ENG` VARCHAR(50) NULL DEFAULT NULL COMMENT '영문코드명',
	  `CD_DESC` VARCHAR(300) NULL DEFAULT NULL COMMENT '코드상세설명',
	  `USE_YN` VARCHAR(1) NOT NULL COMMENT '사용여부',
	  `SORT_SEQ` INT(11) NOT NULL DEFAULT '0' COMMENT '코드정렬순번',
	  `MOD_ID` VARCHAR(12) NULL DEFAULT NULL COMMENT '변경자ID',
	  `MOD_DT` DATE NULL DEFAULT NULL COMMENT '변경일자',
	  `CRE_ID` VARCHAR(12) NOT NULL COMMENT '생성자ID',
	  `CRE_DT` DATE NOT NULL COMMENT '생성일자',
	  PRIMARY KEY (`CD_DO`, `CD_UP`, `CD_DN`)
	)

	# tasks
	CREATE TABLE `tasks` (
		`id` INT(11) NOT NULL AUTO_INCREMENT,
		`name` VARCHAR(255) NULL DEFAULT NULL,
		`description` VARCHAR(255) NULL DEFAULT NULL,
		`date_created` DATETIME NULL DEFAULT NULL,
		`finished` BIT(1) NOT NULL,
		PRIMARY KEY (`id`)
	)
	COLLATE='latin1_swedish_ci'
	ENGINE=MyISAM
	;