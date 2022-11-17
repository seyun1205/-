/*
 Navicat Premium Data Transfer

 Source Server         : Connect
 Source Server Type    : MySQL
 Source Server Version : 50612
 Source Host           : localhost:3306
 Source Schema         : connect

 Target Server Type    : MySQL
 Target Server Version : 50612
 File Encoding         : 65001

 Date: 17/11/2022 11:18:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `username` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ctime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('ddd', '小宇', '好饿好饿', '2022-11-11 16:29:23');

-- ----------------------------
-- Table structure for counselor_records
-- ----------------------------
DROP TABLE IF EXISTS `counselor_records`;
CREATE TABLE `counselor_records`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `from_user_id` bigint(255) NOT NULL COMMENT '消息发起方',
  `to_user_id` bigint(255) NOT NULL COMMENT '消息接收方',
  `message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '消息体',
  `create_time` datetime(0) NOT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '咨询记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of counselor_records
-- ----------------------------
INSERT INTO `counselor_records` VALUES (1589646530331983873, 1, 2, '职场上的问题', '2022-11-07 23:50:42');

-- ----------------------------
-- Table structure for knowlege
-- ----------------------------
DROP TABLE IF EXISTS `knowlege`;
CREATE TABLE `knowlege`  (
  `kno` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`kno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for questionbank
-- ----------------------------
DROP TABLE IF EXISTS `questionbank`;
CREATE TABLE `questionbank`  (
  `question` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`question`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of questionbank
-- ----------------------------
INSERT INTO `questionbank` VALUES ('平常感兴趣的事我不照样感兴趣。');
INSERT INTO `questionbank` VALUES ('我一阵阵哭出来或觉得想哭。');
INSERT INTO `questionbank` VALUES ('我不对将来抱有希望。');
INSERT INTO `questionbank` VALUES ('我与异性密切接触时不和以往一样感到愉快。');
INSERT INTO `questionbank` VALUES ('我发觉我的体重在下降。');
INSERT INTO `questionbank` VALUES ('我吃得不跟平常一样多。');
INSERT INTO `questionbank` VALUES ('我心跳比平时快。');
INSERT INTO `questionbank` VALUES ('我无缘无故的感到疲乏。');
INSERT INTO `questionbank` VALUES ('我晚上睡眠不好。');
INSERT INTO `questionbank` VALUES ('我有便秘的苦恼。');
INSERT INTO `questionbank` VALUES ('我比平常容易生气激动。');
INSERT INTO `questionbank` VALUES ('我的头脑不跟平常一样清楚。');
INSERT INTO `questionbank` VALUES ('我的生活过的没有意思。');
INSERT INTO `questionbank` VALUES ('我觉得一天之中早晨不是最好的。');
INSERT INTO `questionbank` VALUES ('我觉得不安而平静不下来。');
INSERT INTO `questionbank` VALUES ('我觉得作出决定是不容易的。');
INSERT INTO `questionbank` VALUES ('我觉得经常做的事情很有困难。');
INSERT INTO `questionbank` VALUES ('我觉得自己是个没用的人，没人需要我。');
INSERT INTO `questionbank` VALUES ('我觉得闷闷不乐，情绪低沉。');
INSERT INTO `questionbank` VALUES ('我认为如果我死了别人会生活得好些。');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `identify` int(5) DEFAULT NULL,
  `id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`username`, `password`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '123456', 3, 1);
INSERT INTO `user` VALUES ('ddd', '123', 1, 2);
INSERT INTO `user` VALUES ('pro', '123', 2, 3);

SET FOREIGN_KEY_CHECKS = 1;
