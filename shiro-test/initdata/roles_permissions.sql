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

 Date: 23/11/2018 09:19:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permission` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of roles_permissions
-- ----------------------------
INSERT INTO `roles_permissions` VALUES (1, 'admin', 'user:select');
INSERT INTO `roles_permissions` VALUES (2, 'user', 'user:delete');

SET FOREIGN_KEY_CHECKS = 1;
