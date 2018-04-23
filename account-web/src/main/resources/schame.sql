create database account;

CREATE TABLE `account`.`a_user` (
  `id` VARCHAR(36) NOT NULL COMMENT '主键',
  `name` VARCHAR(45) NULL COMMENT '用户名',
  `nickName` VARCHAR(45) NULL COMMENT '昵称',
  `password` VARCHAR(45) NULL COMMENT '密码',
  `createDate` DATETIME NULL COMMENT '注册时间',
  `pictureUrl` VARCHAR(100) NULL COMMENT '图像地址',
  `online` INT NULL COMMENT '在线时长',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '用户表';


ALTER TABLE `account`.`a_user` 
DROP COLUMN `pictureUrl`,
DROP COLUMN `createDate`,
DROP COLUMN `nickName`,
CHANGE COLUMN `create_date` `create_date` DATETIME NULL COMMENT '注册日期' ,
CHANGE COLUMN `nick_name` `nick_name` VARCHAR(255) NULL DEFAULT NULL COMMENT '昵称' ,
CHANGE COLUMN `picture_url` `picture_url` VARCHAR(255) NULL DEFAULT NULL COMMENT '头像地址' ;


CREATE TABLE `account`.`a_account` (
  `id` VARCHAR(36) NOT NULL COMMENT '主键',
  `name` VARCHAR(45) NULL COMMENT '账本名称',
  `describe` VARCHAR(100) NULL COMMENT '账本描述',
  `create_date` DATETIME NULL COMMENT '创建时间',
  `user_id` VARCHAR(36) NULL COMMENT '用户主键',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '账本';
ALTER TABLE `account`.`a_account` 
CHANGE COLUMN `describe` `description` VARCHAR(100) NULL DEFAULT NULL COMMENT '账本描述' ;

CREATE TABLE `account`.`a_category` (
  `id` VARCHAR(36) NOT NULL COMMENT '主键',
  `name` VARCHAR(45) NOT NULL COMMENT '名称',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `type` VARCHAR(10) NOT NULL COMMENT '收支类别',
  `parent_id` VARCHAR(36) NULL COMMENT '父类别ID',
  `account_id` VARCHAR(36) NOT NULL COMMENT '账本ID',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '收支类别表';


CREATE TABLE `account`.`a_tally` (
  `id` VARCHAR(36) NOT NULL COMMENT '主键',
  `money` FLOAT NULL COMMENT '金额',
  `create_date` DATETIME NULL COMMENT '创建日期',
  `category_type` VARCHAR(10) NULL COMMENT '收支类型',
  `category_id` VARCHAR(36) NULL COMMENT '类别主键',
  `category_name` VARCHAR(45) NULL COMMENT '类别名称',
  `account_id` VARCHAR(36) NULL COMMENT '账本主键',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '金额表';

