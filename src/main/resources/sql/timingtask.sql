/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : timingtask

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-03-27 16:58:38
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
  `isAppoin` int(11) DEFAULT NULL COMMENT '是否指定执行日期 0否 1是',
  `frequency` int(11) DEFAULT '0' COMMENT '不指定执行日期的执行频度  单位分钟',
  `appoinDate` datetime DEFAULT NULL COMMENT '指定的日期，时分秒',
  `emailSubject` varchar(500) DEFAULT NULL COMMENT '邮件主题',
  `requestMode` int(11) DEFAULT NULL COMMENT '请求方式  1 get  2、post application/json 3、post from',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of time_task
-- ----------------------------
INSERT INTO `time_task` VALUES ('1', '邮件发送测试', '1', '953712390@qq.com', null, null, 'wo', '123', '1', '2020-03-19 14:40:48', '1', '2020-03-25 17:06:09', '', '0', '10', '2020-03-19 15:00:00', '测试邮件', null);
INSERT INTO `time_task` VALUES ('2', '邮件发送测试', '1', '953712390@qq.com', null, null, 'wo', '123', '1', '2020-03-19 15:10:09', '1', '2020-03-19 15:10:09', '', '0', '10', '2020-03-19 15:00:00', '测试邮件', null);
INSERT INTO `time_task` VALUES ('3', '发送get请求', '2', null, 'http://127.0.0.1:8301/task/getAllSetting', '{}', 'wo', null, '1', '2020-03-20 09:39:30', '1', '2020-03-20 09:39:30', '', '0', '10', '2020-03-19 15:00:00', null, '1');
INSERT INTO `time_task` VALUES ('5', '发送post请求,application/json', '2', null, 'http://127.0.0.1:8301/task/deleteTimeTask', '{\"modifyAdminId\":1,\"id\":1}', 'wo', null, '1', '2020-03-20 11:21:10', '1', '2020-03-20 11:21:10', '', '0', '10', '2020-03-19 15:00:00', null, '2');
INSERT INTO `time_task` VALUES ('6', '1', '1', '1', '', '{}', '1', '1', '1', '2020-03-27 15:55:35', '1', '2020-03-27 15:55:35', '', '0', '1', null, '1', '1');

-- ----------------------------
-- Table structure for `time_task_log`
-- ----------------------------
DROP TABLE IF EXISTS `time_task_log`;
CREATE TABLE `time_task_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '定时任务日志表',
  `taskId` int(11) DEFAULT NULL COMMENT '任务表主键',
  `nextTime` datetime DEFAULT NULL,
  `isExec` int(1) DEFAULT '0' COMMENT '是否已经执行',
  `execTime` datetime DEFAULT NULL COMMENT '执行时间',
  `isdel` int(1) DEFAULT '0' COMMENT '0正常1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of time_task_log
-- ----------------------------
INSERT INTO `time_task_log` VALUES ('16', '5', '2020-03-20 11:21:10', '1', '2020-03-20 11:21:48', '0');
INSERT INTO `time_task_log` VALUES ('17', '5', '2020-03-20 11:21:48', '1', '2020-03-20 11:22:55', '0');
INSERT INTO `time_task_log` VALUES ('18', '5', '2020-03-20 11:22:55', '1', '2020-03-25 17:05:42', '0');
INSERT INTO `time_task_log` VALUES ('19', '5', '2020-03-25 17:05:42', '1', '2020-03-25 17:05:43', '0');
INSERT INTO `time_task_log` VALUES ('20', '5', '2020-03-25 17:05:43', '1', '2020-03-25 17:05:44', '0');
INSERT INTO `time_task_log` VALUES ('21', '5', '2020-03-25 17:05:44', '1', '2020-03-25 17:05:45', '0');
INSERT INTO `time_task_log` VALUES ('22', '5', '2020-03-25 17:05:45', '1', '2020-03-25 17:05:46', '0');
INSERT INTO `time_task_log` VALUES ('23', '5', '2020-03-25 17:05:46', '1', '2020-03-25 17:05:47', '0');
INSERT INTO `time_task_log` VALUES ('24', '5', '2020-03-25 17:05:47', '1', '2020-03-25 17:05:48', '0');
INSERT INTO `time_task_log` VALUES ('25', '5', '2020-03-25 17:05:48', '1', '2020-03-25 17:05:49', '0');
INSERT INTO `time_task_log` VALUES ('26', '5', '2020-03-25 17:05:49', '1', '2020-03-25 17:05:50', '0');
INSERT INTO `time_task_log` VALUES ('27', '5', '2020-03-25 17:05:50', '1', '2020-03-25 17:05:51', '0');
INSERT INTO `time_task_log` VALUES ('28', '5', '2020-03-25 17:05:51', '1', '2020-03-25 17:05:52', '0');
INSERT INTO `time_task_log` VALUES ('29', '5', '2020-03-25 17:05:52', '1', '2020-03-25 17:05:53', '0');
INSERT INTO `time_task_log` VALUES ('30', '5', '2020-03-25 17:05:53', '1', '2020-03-25 17:05:54', '0');
INSERT INTO `time_task_log` VALUES ('31', '5', '2020-03-25 17:05:54', '1', '2020-03-25 17:05:55', '0');
INSERT INTO `time_task_log` VALUES ('32', '5', '2020-03-25 17:05:55', '1', '2020-03-25 17:05:56', '0');
INSERT INTO `time_task_log` VALUES ('33', '5', '2020-03-25 17:05:56', '1', '2020-03-25 17:05:57', '0');
INSERT INTO `time_task_log` VALUES ('34', '5', '2020-03-25 17:05:57', '1', '2020-03-25 17:05:58', '0');
INSERT INTO `time_task_log` VALUES ('35', '5', '2020-03-25 17:05:58', '1', '2020-03-25 17:05:59', '0');
INSERT INTO `time_task_log` VALUES ('36', '5', '2020-03-25 17:05:59', '1', '2020-03-25 17:06:00', '0');
INSERT INTO `time_task_log` VALUES ('37', '5', '2020-03-25 17:06:00', '1', '2020-03-25 17:06:01', '0');
INSERT INTO `time_task_log` VALUES ('38', '5', '2020-03-25 17:06:01', '1', '2020-03-25 17:06:02', '0');
INSERT INTO `time_task_log` VALUES ('39', '5', '2020-03-25 17:06:02', '1', '2020-03-25 17:06:03', '0');
INSERT INTO `time_task_log` VALUES ('40', '5', '2020-03-25 17:06:03', '1', '2020-03-25 17:06:04', '0');
INSERT INTO `time_task_log` VALUES ('41', '5', '2020-03-25 17:06:04', '1', '2020-03-25 17:06:05', '0');
INSERT INTO `time_task_log` VALUES ('42', '5', '2020-03-25 17:06:05', '1', '2020-03-25 17:06:06', '0');
INSERT INTO `time_task_log` VALUES ('43', '5', '2020-03-25 17:06:06', '1', '2020-03-25 17:06:07', '0');
INSERT INTO `time_task_log` VALUES ('44', '5', '2020-03-25 17:06:07', '1', '2020-03-25 17:06:08', '0');
INSERT INTO `time_task_log` VALUES ('45', '5', '2020-03-25 17:06:08', '1', '2020-03-25 17:06:09', '0');
INSERT INTO `time_task_log` VALUES ('46', '5', '2020-03-25 17:06:09', '0', null, '0');
INSERT INTO `time_task_log` VALUES ('47', '6', '2020-03-27 15:56:35', '0', null, '0');

-- ----------------------------
-- Table structure for `time_user`
-- ----------------------------
DROP TABLE IF EXISTS `time_user`;
CREATE TABLE `time_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户表',
  `account` varchar(50) DEFAULT NULL COMMENT '账号',
  `pwd` varchar(36) DEFAULT NULL COMMENT '密码',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `isdel` bit(1) DEFAULT b'0' COMMENT '0正常1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of time_user
-- ----------------------------
INSERT INTO `time_user` VALUES ('1', '1', 'c4ca4238a0b923820dcc509a6f75849b', '2020-03-25 11:11:38', '2020-03-25 11:11:42', '');
