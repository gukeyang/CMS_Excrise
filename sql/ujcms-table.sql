/*
 Navicat Premium Data Transfer

 Source Server         : ujcmsnew
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 121.4.47.113:3306
 Source Schema         : ujcms-table

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 10/03/2023 14:59:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for characteristic
-- ----------------------------
DROP TABLE IF EXISTS `characteristic`;
CREATE TABLE `characteristic`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `chTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `chContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章内容',
  `firstTarget` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属一级目录',
  `secondTarget` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属二级目录',
  `sattus` int(0) DEFAULT 0 COMMENT '文章审核状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of characteristic
-- ----------------------------
INSERT INTO `characteristic` VALUES (1, '1', '11', '1', '1', 0);
INSERT INTO `characteristic` VALUES (2, '1', '1', '1', '1', 0);

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试题名称',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试题内容',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试题正确答案',
  `classify` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试题分类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for first
-- ----------------------------
DROP TABLE IF EXISTS `first`;
CREATE TABLE `first`  (
  `first_Id` int(0) NOT NULL AUTO_INCREMENT,
  `firstTargetName` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`first_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of first
-- ----------------------------
INSERT INTO `first` VALUES (1, 'usera');
INSERT INTO `first` VALUES (2, 'guanliyuaad');
INSERT INTO `first` VALUES (3, '12345677890');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userAuthority` int(0) DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, 'admin', 'admin', 'gukeyang', 0, NULL);
INSERT INTO `manager` VALUES (2, '3056726345@qq.com', '12345677890', 'U平台567808号', NULL, '3056726345@qq.com');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `notice_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `notice_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `notice_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发布时间',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公告审核状态',
  `first_target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '一级目录',
  `html_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (4, 'sad', 'sad', '2023-03-09-08-25', '21', 'sda', 'das');
INSERT INTO `notice` VALUES (5, 'string', 'string', '2023-03-09-08-25', '0', '中心要闻', 'string');
INSERT INTO `notice` VALUES (6, 'string', 'string', '2023-03-09-08-25', '0', 'string', 'string');
INSERT INTO `notice` VALUES (7, 'string', 'string', '2023-03-09-08-25', '0', 'string', 'string');
INSERT INTO `notice` VALUES (8, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (9, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (10, 'string', 'string', NULL, '0', '中心要闻', 'string');
INSERT INTO `notice` VALUES (11, 'string', 'string', '2023-03-09-08-25', '0', '中心要闻', 'string');
INSERT INTO `notice` VALUES (12, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (13, 'string', 'string', '2023-03-09-08-25', '0', 'string', 'string');
INSERT INTO `notice` VALUES (14, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (15, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (16, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (17, 'string', 'string', NULL, '0', '中心要闻', 'string');
INSERT INTO `notice` VALUES (18, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (19, 'string', 'string', NULL, '0', '中心要闻', 'string');
INSERT INTO `notice` VALUES (20, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (21, 'string', 'string', '2023-03-09-08-25', '0', '中心要闻', 'string');
INSERT INTO `notice` VALUES (22, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (23, 'string', 'string', '2023-03-09-08-25', '0', 'string', 'string');
INSERT INTO `notice` VALUES (24, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (25, 'string', 'string', '2023-03-09-08-25', '0', 'string', 'string');
INSERT INTO `notice` VALUES (26, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (27, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (28, 'string', 'string', '2023-03-09-08-25', '0', 'string', 'string');
INSERT INTO `notice` VALUES (29, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (30, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (31, 'string', 'string', NULL, '0', 'string', 'string');
INSERT INTO `notice` VALUES (32, 'etrrtrt', 'wree', NULL, '0', 'ewwe', NULL);
INSERT INTO `notice` VALUES (33, 'eeeee', 'wwww', NULL, '0', 'qqqq', NULL);

-- ----------------------------
-- Table structure for object_item
-- ----------------------------
DROP TABLE IF EXISTS `object_item`;
CREATE TABLE `object_item`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `objectName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `size` bigint(0) DEFAULT NULL,
  `htitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `hpart` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of object_item
-- ----------------------------
INSERT INTO `object_item` VALUES (1633827074048258049, '2023-03-09&&1678369703499.png', 216017, '1111', '1111');

-- ----------------------------
-- Table structure for part_m
-- ----------------------------
DROP TABLE IF EXISTS `part_m`;
CREATE TABLE `part_m`  (
  `id` bigint(0) DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `part` bigint(0) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of part_m
-- ----------------------------
INSERT INTO `part_m` VALUES (1633730671978741762, '1111', '1111', 1111);
INSERT INTO `part_m` VALUES (1633806263680618497, 'sad', 'asd', 132);
INSERT INTO `part_m` VALUES (1633809769677819905, 'sad', 'asd', 13);
INSERT INTO `part_m` VALUES (1633811812152832001, 'sadas', 'sdas', 16);
INSERT INTO `part_m` VALUES (1633825674257903617, '1', '1', 1);

-- ----------------------------
-- Table structure for part_s
-- ----------------------------
DROP TABLE IF EXISTS `part_s`;
CREATE TABLE `part_s`  (
  `id` bigint(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of part_s
-- ----------------------------
INSERT INTO `part_s` VALUES (1633729900327469058, '123', '213');
INSERT INTO `part_s` VALUES (1633732393107222529, '111', '1111');
INSERT INTO `part_s` VALUES (1633809806679969793, 'asd', '12');
INSERT INTO `part_s` VALUES (1633811845224919041, 'sad', '12');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `imgPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '目录',
  `imgTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '视频标题',
  `imgName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '视频内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for second
-- ----------------------------
DROP TABLE IF EXISTS `second`;
CREATE TABLE `second`  (
  `secondId` int(0) NOT NULL AUTO_INCREMENT,
  `firstId` int(0) DEFAULT NULL,
  `secondTargetName` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`secondId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of second
-- ----------------------------
INSERT INTO `second` VALUES (1, 21, '12344');

SET FOREIGN_KEY_CHECKS = 1;
