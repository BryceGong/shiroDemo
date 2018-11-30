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

 Date: 23/11/2018 09:19:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES (1, 'bryce', 'admin');
INSERT INTO `user_roles` VALUES (2, 'bryce', 'user');

SET FOREIGN_KEY_CHECKS = 1;
