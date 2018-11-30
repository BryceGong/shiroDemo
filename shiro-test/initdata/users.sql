/*
 Navicat Premium Data Transfer

 Source Server         : manageNet
 Source Server Type    : MySQL
 Source Server Version : 50512
 Source Host           : 120.79.52.156:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50512
 File Encoding         : 65001

 Date: 23/11/2018 09:20:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'bryce', '123456');

SET FOREIGN_KEY_CHECKS = 1;
