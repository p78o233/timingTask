/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : timingtask

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-03-11 17:17:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `time_setting`
-- ----------------------------
DROP TABLE IF EXISTS `time_setting`;
CREATE TABLE `time_setting` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '设置表',
  `settingName` varchar(255) DEFAULT NULL COMMENT '设置名称',
  `settingKey` varchar(255) DEFAULT NULL COMMENT '设置的键',
  `settingValue` varchar(500) DEFAULT NULL COMMENT '设置的值',
  `createAdminId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifyAdminId` int(11) DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  `isdel` bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of time_setting
-- ----------------------------

-- ----------------------------
-- Table structure for `time_task`
-- ----------------------------
DROP TABLE IF EXISTS `time_task`;
CREATE TABLE `time_task` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '任务表',
  `taskName` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `taskCategory` int(11) DEFAULT NULL COMMENT '任务类别 1、发送邮件  2、访问接口',
  `emailAddress` varchar(500) DEFAULT NULL COMMENT '邮箱地址',
  `requestAddress` text COMMENT '请求地址',
  `taskParam` text COMMENT '请求参数json格式',
  `personInCharge` varchar(50) DEFAULT NULL COMMENT '负责人',
  `emailContent` text COMMENT '邮件内容',
  `createAdminId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `modifyAdminId` int(11) DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  `isdel` bit(1) DEFAULT b'0' COMMENT '是否删除0正常 1删除',
  `isAppoin` bit(1) DEFAULT NULL COMMENT '是否指定执行日期 0否 1是',
  `frequency` float(11,0) DEFAULT '0' COMMENT '不指定执行日期的执行频度  单位分钟',
  `appoinDate` datetime DEFAULT NULL COMMENT '指定的日期，时分秒',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of time_task
-- ----------------------------

-- ----------------------------
-- Table structure for `time_user`
-- ----------------------------
DROP TABLE IF EXISTS `time_user`;
CREATE TABLE `time_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户表',
  `account` varchar(50) DEFAULT NULL COMMENT '账号',
  `pwd` varchar(30) DEFAULT NULL COMMENT '密码',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `isdel` bit(1) DEFAULT b'0' COMMENT '0正常1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of time_user
-- ----------------------------
