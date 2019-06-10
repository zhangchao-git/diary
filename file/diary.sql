/*
Navicat MySQL Data Transfer

Source Server         : 我的阿里云
Source Server Version : 50643
Source Host           : 47.98.37.85:3306
Source Database       : diary

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-06-10 14:20:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for consume
-- ----------------------------
DROP TABLE IF EXISTS `consume`;
CREATE TABLE `consume` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` date DEFAULT NULL COMMENT '日期',
  `diaryId` int(11) DEFAULT NULL COMMENT '日记id',
  `type` int(1) DEFAULT NULL COMMENT '0:收入/1:支出',
  `path` varchar(50) DEFAULT NULL COMMENT '收入/支出路径',
  `amount` double(9,2) DEFAULT NULL COMMENT '金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `id` (`id`),
  KEY `diaryId` (`diaryId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for diary
-- ----------------------------
DROP TABLE IF EXISTS `diary`;
CREATE TABLE `diary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `date` date DEFAULT NULL COMMENT '发生日期',
  `weather` varchar(50) DEFAULT NULL COMMENT '天气',
  `mood` varchar(50) DEFAULT NULL COMMENT '心情',
  `keywords` varchar(50) DEFAULT NULL COMMENT '关键词',
  `longitude` double(9,6) DEFAULT NULL COMMENT '经度',
  `latitude` double(9,6) DEFAULT NULL COMMENT '纬度',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `content` varchar(3000) NOT NULL COMMENT '内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for platform_user
-- ----------------------------
DROP TABLE IF EXISTS `platform_user`;
CREATE TABLE `platform_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `user_show_name` varchar(50) NOT NULL COMMENT '用户显示名称',
  `login_name` varchar(50) NOT NULL COMMENT '登录用户名',
  `password` varchar(50) NOT NULL COMMENT '登录密码. 密码一律用不可逆加密形式',
  `user_status` int(2) NOT NULL COMMENT '用户状态，0-正常，1-禁用',
  `user_type` int(2) NOT NULL COMMENT '用户类型，0-管理员，1-浏览用户',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
