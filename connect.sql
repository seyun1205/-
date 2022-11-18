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

 Date: 18/11/2022 23:00:17
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
  `content_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`kno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of knowlege
-- ----------------------------
INSERT INTO `knowlege` VALUES ('01', '“三明治效应”', '在批评心理学中，人们把批评的内容夹在两个表扬之中从而使受批评者愉快地接受批评的现象，称之为三明治效应。这种现象就如三明治，第一层总是认同、赏识、肯定、关爱对方的优点或积极面，中间这一层夹着建议、批评或不同观点，第三层总是鼓励、希望、信任、支持和帮助，使之后味无穷。比如：今天的汤真好喝，就是稍微咸了一点，下次清淡点我能连喝三大碗。');
INSERT INTO `knowlege` VALUES ('02', '“反问句效应”', '不想终结聊天话题，就要少说反问句，如“不然呢？”“我怎么知道？”“听明白没？”说这些话时或许别无他意，但其实伤人又伤心，负作用非常大。生活中能用陈述句就不用反问句，因为80%的反问都是拿来终结话题的大杀器。');
INSERT INTO `knowlege` VALUES ('03', '“富兰克林效应”', '那些曾帮助过你的人会更愿意帮你。想要提高人与人之间的关系，最简单的方式就是让他帮你一次，拉近彼此的心理距离。所以，如果想得到别人的好感，主动开口是没坏处的。');
INSERT INTO `knowlege` VALUES ('04', '“说谎假象”', '说谎的人会刻意纠正自己的动作，露出破绽。比如感到吃惊时，他会一直维持吃惊的表情，而不是一秒钟回到正常的表情；说谎者描述事件经过时会故意说得很顺畅，还加以修饰，但往往真实的东西都需要回忆，才能准确地表达出来。');
INSERT INTO `knowlege` VALUES ('05', '我们的眼泪为何而流', '我们哭泣是因为哭泣会让我们感觉好些吗?或者哭泣能清除掉体内那些让我们感觉压抑的化学物质吗?抑或是一次正确的哭泣能让你受到关注、获得认同?我们会在疼痛的时候流眼泪，但流泪的目的是什么呢?一位名叫Oren Hasson科学家最近提出了一条新理论来解释为什么哭泣在进化:眼泪可以让外界知道你已经降低了防范。“哭泣是一项已经高度进化的行为，”以色列特拉维夫大学(Tel Aviv University)的进化生物学家Oren Hasson说，“我通过分析研究认为，泪水可以使视线模糊，因而可以降低防范，还可以有效地传递出让对方顺从你的信号。');
INSERT INTO `knowlege` VALUES ('06', '合理发怒有益血压', '没错，生气会让人血压上升。但美国卡内基梅隆大学的研究发现，在压抑的情况下恰当地以愤怒回应，血压不但会维持正常水平，制造压力感的激素———皮质醇的分泌量也会相应减少。心理学研究表明，愤怒让人多了一份积极的心态和掌控感;该出手时不出手，畏缩不前、极力克制内心情绪，压力激素反而会骤升。长此以往，心脏病就会“盯上你\'。');
INSERT INTO `knowlege` VALUES ('07', '电子游戏帮你锻炼', '谁说玩电子游戏让人变胖?美国迈阿密大学的科学家们发现,人在玩电子游戏时，心率加快、呼吸急促，身体因此消耗更多的能量。阿莱特。佩里博士认为，如果不能参加真正的体育锻炼，玩游戏也能帮着减肥，至少比傻坐在沙发上，吃着薯条看电视好，但前提是玩的时间不能太长。');
INSERT INTO `knowlege` VALUES ('08', '偷点小懒助你长寿', '天天早起，忙忙碌碌的人可能过早地“钻进坟墓”。不时地偷个小懒，不仅能减轻工作压力，还是长寿的关键。研究表明，中午小憩片刻比打网球更有助长寿。老人总是跑步锻炼反而会消耗本来用于细胞再生或抵抗疾病的能量。心理专家称，就算躺在家里做白日梦，那也是大脑在处理重要的信息，你的思维反而更活跃。');
INSERT INTO `knowlege` VALUES ('09', '说点粗话缓解疼痛', '说粗话是被人不齿的坏习惯，但却有缓解疼痛的好处。心理学家理查德·斯蒂芬博士认为，说粗话和肾上腺素的调节作用有关，它加重了人的侵略倾向。研究表明，一个人越想侵犯别人，他对痛越不敏感。我们的祖先在没有麻醉药的情况下接受外科手术时，嘴里都会咬块木板，其实他们完全可以破口大骂，减轻痛苦。');
INSERT INTO `knowlege` VALUES ('10', '短期压力增强记忆', '长期的生活压力，如离婚等，能破坏人的免疫系统，让人容易感染。但布法罗大学的研究发现，短期的紧迫性事件能提升大脑的学习能力和记忆力。这是因为，压力激素影响大脑主管情感和学习能力的部分区域。压力剧增会使传递信息的物质———谷氨酸盐的传播速度加快，从而增进记忆力。');
INSERT INTO `knowlege` VALUES ('11', '吵闹音乐激发脑力', '参加摇滚派对，调高音乐的音量都有助于激发大脑的活力。英国曼彻斯特大学的研究发现，人内耳里的球囊只对超过90分贝的音量敏感。而球囊和大脑处理性、快乐和饥饿感的区域相连。如果通过高分贝音乐的刺激使这些欲望得到满足，我们内心就会非常平静、幸福。不开心时，可以用高分贝音乐激发你的“快乐激素”。');
INSERT INTO `knowlege` VALUES ('12', '烦躁不安可以减肥', '在椅子上左右摇晃招人讨厌，但是美国梅奥诊所的专家发现，坐立不安的人要比普通人更苗条。无论是敲打桌子、浑身乱颤，还是伸胳膊蹬腿，打哈欠，这样的人每天都要多消耗350卡路里的能量，每年无形中减肥9—27斤。所以胖人们不要总抱怨找不到合适的减肥方法。');
INSERT INTO `knowlege` VALUES ('13', '被子不叠杀死尘螨', '哮喘症患者最好别叠被子。因为房间里的尘螨在干燥、暴露的环境中不易生存。而叠好的被子容易保留人体的温度和汗液，给尘螨创造生存条件。研究者说：“把被子摊在床上，里边的潮湿气体很快就会干燥，而外部的湿气又无法进入，各类螨虫会脱水而死。”');
INSERT INTO `knowlege` VALUES ('14', '平日小赌赶走抑郁', '赌徒比常人心理更健康。研究人员发现，年龄超过65岁的人参加适度的赌博游戏，比如每周去一次赛马场，他们的大脑会更加活跃，善于与人交流。上岁数的人，在网上玩点在线扑克游戏或者电子赌博游戏，能有效排解抑郁，阻止大脑早衰。');

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
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '123456', 3);
INSERT INTO `user` VALUES ('ddd', '123', 1);
INSERT INTO `user` VALUES ('大宝', '123456', 2);

SET FOREIGN_KEY_CHECKS = 1;
