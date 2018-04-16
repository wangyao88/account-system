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
