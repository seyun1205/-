/*
 Navicat Premium Data Transfer

 Source Server         : Connect
 Source Server Type    : MySQL
 Source Server Version : 50612
 Source Host           : localhost:3306
 Source Schema         : connect2

 Target Server Type    : MySQL
 Target Server Version : 50612
 File Encoding         : 65001

 Date: 22/11/2022 22:16:22
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
-- Table structure for counselor
-- ----------------------------
DROP TABLE IF EXISTS `counselor`;
CREATE TABLE `counselor`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `good_at` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '擅长方向',
  `number_consulting` bigint(255) NOT NULL DEFAULT 0 COMMENT '咨询次数',
  `create_time` datetime(0) NOT NULL COMMENT '填写信息时间',
  `introduce` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '自我介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '咨询师信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of counselor
-- ----------------------------
INSERT INTO `counselor` VALUES (1, 2, '社会心理学', 0, '2022-11-09 21:51:49', '李四，男，副教授，南开大学社会心理学博士，天津医科大学心理健康教育中心测评部主任。从事大学生心理健康教育工作12年。主要咨询领域：大学生人际关系、压力管理等。');
INSERT INTO `counselor` VALUES (2, 3, '临床心理学', 0, '2022-11-09 21:57:32', '王五，男，讲师，临床心理与心理咨询方向硕士，中国心理学会注册心理师，国家二级心理咨询师，天津医科大学心理健康教育中心专职教师。曾先后参加中国心理学会临床心理学注册工作委员会天津督导点连续培训项目、团体咨询师技能培训、第三届中挪精神分析连续培训项目、EMDR创伤心理治疗，中英婴儿观察连续培训项目、第七届加拿大青少年游戏治疗连续培训、首届临床催眠连续培训（天津）等培训项目。心理咨询取向为人本主义、动力学。');
INSERT INTO `counselor` VALUES (3, 4, '临床治疗', 0, '2022-11-09 22:01:02', '王英，女，博士，副教授，天津医科大学心理学教师，天津心理卫生协会常务理事。曾在三甲医院神经内科工作十多年，有丰富的临床经验。2006年开始做兼职心理咨询师，接受过认知行为疗法，焦点解决短期心理治疗，沙盘游戏治疗，情绪聚焦疗法等系统培训。累计咨询时长超过5000小时。擅长领域：恋爱情感、人际关系、抑郁障碍、身心症状。多次评为天津医科大学优秀心理咨询师。');
INSERT INTO `counselor` VALUES (4, 5, '心理分析', 0, '2022-11-09 22:02:13', '李建伟，男，精神科主治医师，二级心理咨询师。以情绪聚焦、精神分析等视角来理解患者。累计咨询时长超过10000小时。擅长处理焦虑障碍，抑郁障碍以及人际关系困扰（包括夫妻，以及亲子关系）。接受过中挪精神分析，中美团体心理，情绪聚焦疗法等系统培训，并且一直接受案例督导。');
INSERT INTO `counselor` VALUES (5, 6, '心理解压', 0, '2022-11-09 22:03:15', '刘惠军，女，心理学博士，天津医科大学心理学研究所教授，副所长，心理健康教育中心常务副主任。中国心理学会生理心理学分会理事，中国心理卫生协会大学生心理咨询专业委员会委员，天津市心理学会和心理卫生系会常务理事，天津市医学会医学人文分会主任委员，天津市肿瘤心理专委会副主任委员。咨询领域：压力管理、抑郁、焦虑和愤怒情绪调节，积极心理调动，医患冲突');
INSERT INTO `counselor` VALUES (6, 7, '内观疗法', 0, '2022-11-09 22:04:43', '毛富强，男，教授、博士生导师，天津医科大学心理健康教育中心主任、精神卫生与心理学系主任、第二医院临床心理科主任，教育部精神医学教学指导委员会委员，中国心理卫生学会森田疗法专委会副主任委员、心理治疗与心理咨询专委会委员、内观疗法组主任委员，天津市教育两委新冠肺炎疫情防控心理支持热线督导专家。');

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
INSERT INTO `counselor_records` VALUES (1594258344881627138, 1, 2, '大幅度发', '2022-11-20 17:16:24');
INSERT INTO `counselor_records` VALUES (1594258388108124161, 2, 1, '光污染个人股', '2022-11-20 17:16:34');
INSERT INTO `counselor_records` VALUES (1594278581597319169, 2, 1, '你好', '2022-11-20 18:36:49');
INSERT INTO `counselor_records` VALUES (1594278610085031938, 1, 2, '你好', '2022-11-20 18:36:56');
INSERT INTO `counselor_records` VALUES (1594278630272217090, 1, 2, '\n在的', '2022-11-20 18:37:00');
INSERT INTO `counselor_records` VALUES (1594279574674288642, 1, 2, '你好', '2022-11-20 18:40:46');
INSERT INTO `counselor_records` VALUES (1594279619146493953, 2, 1, '在的', '2022-11-20 18:40:56');
INSERT INTO `counselor_records` VALUES (1594279653229408257, 1, 2, '\nOK', '2022-11-20 18:41:04');
INSERT INTO `counselor_records` VALUES (1594279752248537090, 1, 2, '\n数据传输你们在登录的时候要给一个用户数据', '2022-11-20 18:41:28');
INSERT INTO `counselor_records` VALUES (1594279791184261121, 1, 2, '\n\"id\":\"1\",\"username\":\"张三\",\"password\":\"123456\",\"role\":1', '2022-11-20 18:41:37');
INSERT INTO `counselor_records` VALUES (1594279821429387266, 1, 2, '\n这几个参数必须要有', '2022-11-20 18:41:44');
INSERT INTO `counselor_records` VALUES (1595047591167197185, 1, 2, 'kk', '2022-11-22 21:32:35');
INSERT INTO `counselor_records` VALUES (1595047625925394434, 2, 1, '你好', '2022-11-22 21:32:43');
INSERT INTO `counselor_records` VALUES (1595047732641071106, 1, 2, '懂得都懂', '2022-11-22 21:33:09');
INSERT INTO `counselor_records` VALUES (1595047751146340354, 2, 1, '\n简介简介军', '2022-11-22 21:33:13');
INSERT INTO `counselor_records` VALUES (1595054607684075521, 1, 2, '刷刷刷', '2022-11-22 22:00:28');
INSERT INTO `counselor_records` VALUES (1595054629548982273, 2, 1, '撒飒飒', '2022-11-22 22:00:33');
INSERT INTO `counselor_records` VALUES (1595056270528479234, 1, 5, '1', '2022-11-22 22:07:04');

-- ----------------------------
-- Table structure for knowlege
-- ----------------------------
DROP TABLE IF EXISTS `knowlege`;
CREATE TABLE `knowlege`  (
  `kno` int(30) NOT NULL AUTO_INCREMENT,
  `content_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`kno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of knowlege
-- ----------------------------
INSERT INTO `knowlege` VALUES (1, '“三明治效应”', '在批评心理学中，人们把批评的内容夹在两个表扬之中从而使受批评者愉快地接受批评的现象，称之为三明治效应。这种现象就如三明治，第一层总是认同、赏识、肯定、关爱对方的优点或积极面，中间这一层夹着建议、批评或不同观点，第三层总是鼓励、希望、信任、支持和帮助，使之后味无穷。比如：今天的汤真好喝，就是稍微咸了一点，下次清淡点我能连喝三大碗。');
INSERT INTO `knowlege` VALUES (2, '“反问句效应”', '不想终结聊天话题，就要少说反问句，如“不然呢？”“我怎么知道？”“听明白没？”说这些话时或许别无他意，但其实伤人又伤心，负作用非常大。生活中能用陈述句就不用反问句，因为80%的反问都是拿来终结话题的大杀器。');
INSERT INTO `knowlege` VALUES (3, '“富兰克林效应”', '那些曾帮助过你的人会更愿意帮你。想要提高人与人之间的关系，最简单的方式就是让他帮你一次，拉近彼此的心理距离。所以，如果想得到别人的好感，主动开口是没坏处的。');
INSERT INTO `knowlege` VALUES (4, '“说谎假象”', '说谎的人会刻意纠正自己的动作，露出破绽。比如感到吃惊时，他会一直维持吃惊的表情，而不是一秒钟回到正常的表情；说谎者描述事件经过时会故意说得很顺畅，还加以修饰，但往往真实的东西都需要回忆，才能准确地表达出来。');
INSERT INTO `knowlege` VALUES (5, '我们的眼泪为何而流', '我们哭泣是因为哭泣会让我们感觉好些吗?或者哭泣能清除掉体内那些让我们感觉压抑的化学物质吗?抑或是一次正确的哭泣能让你受到关注、获得认同?我们会在疼痛的时候流眼泪，但流泪的目的是什么呢?一位名叫Oren Hasson科学家最近提出了一条新理论来解释为什么哭泣在进化:眼泪可以让外界知道你已经降低了防范。“哭泣是一项已经高度进化的行为，”以色列特拉维夫大学(Tel Aviv University)的进化生物学家Oren Hasson说，“我通过分析研究认为，泪水可以使视线模糊，因而可以降低防范，还可以有效地传递出让对方顺从你的信号。');
INSERT INTO `knowlege` VALUES (6, '合理发怒有益血压', '没错，生气会让人血压上升。但美国卡内基梅隆大学的研究发现，在压抑的情况下恰当地以愤怒回应，血压不但会维持正常水平，制造压力感的激素———皮质醇的分泌量也会相应减少。心理学研究表明，愤怒让人多了一份积极的心态和掌控感;该出手时不出手，畏缩不前、极力克制内心情绪，压力激素反而会骤升。长此以往，心脏病就会“盯上你');
INSERT INTO `knowlege` VALUES (7, '电子游戏帮你锻炼', '谁说玩电子游戏让人变胖?美国迈阿密大学的科学家们发现,人在玩电子游戏时，心率加快、呼吸急促，身体因此消耗更多的能量。阿莱特。佩里博士认为，如果不能参加真正的体育锻炼，玩游戏也能帮着减肥，至少比傻坐在沙发上，吃着薯条看电视好，但前提是玩的时间不能太长。');
INSERT INTO `knowlege` VALUES (8, '偷点小懒助你长寿', '天天早起，忙忙碌碌的人可能过早地“钻进坟墓”。不时地偷个小懒，不仅能减轻工作压力，还是长寿的关键。研究表明，中午小憩片刻比打网球更有助长寿。老人总是跑步锻炼反而会消耗本来用于细胞再生或抵抗疾病的能量。心理专家称，就算躺在家里做白日梦，那也是大脑在处理重要的信息，你的思维反而更活跃。');
INSERT INTO `knowlege` VALUES (9, '说点粗话缓解疼痛', '说粗话是被人不齿的坏习惯，但却有缓解疼痛的好处。心理学家理查德·斯蒂芬博士认为，说粗话和肾上腺素的调节作用有关，它加重了人的侵略倾向。研究表明，一个人越想侵犯别人，他对痛越不敏感。我们的祖先在没有麻醉药的情况下接受外科手术时，嘴里都会咬块木板，其实他们完全可以破口大骂，减轻痛苦。');
INSERT INTO `knowlege` VALUES (10, '短期压力增强记忆', '长期的生活压力，如离婚等，能破坏人的免疫系统，让人容易感染。但布法罗大学的研究发现，短期的紧迫性事件能提升大脑的学习能力和记忆力。这是因为，压力激素影响大脑主管情感和学习能力的部分区域。压力剧增会使传递信息的物质———谷氨酸盐的传播速度加快，从而增进记忆力。');
INSERT INTO `knowlege` VALUES (11, '吵闹音乐激发脑力', '参加摇滚派对，调高音乐的音量都有助于激发大脑的活力。英国曼彻斯特大学的研究发现，人内耳里的球囊只对超过90分贝的音量敏感。而球囊和大脑处理性、快乐和饥饿感的区域相连。如果通过高分贝音乐的刺激使这些欲望得到满足，我们内心就会非常平静、幸福。不开心时，可以用高分贝音乐激发你的“快乐激素”。');
INSERT INTO `knowlege` VALUES (12, '烦躁不安可以减肥', '在椅子上左右摇晃招人讨厌，但是美国梅奥诊所的专家发现，坐立不安的人要比普通人更苗条。无论是敲打桌子、浑身乱颤，还是伸胳膊蹬腿，打哈欠，这样的人每天都要多消耗350卡路里的能量，每年无形中减肥9—27斤。所以胖人们不要总抱怨找不到合适的减肥方法。');
INSERT INTO `knowlege` VALUES (13, '被子不叠杀死尘螨', '哮喘症患者最好别叠被子。因为房间里的尘螨在干燥、暴露的环境中不易生存。而叠好的被子容易保留人体的温度和汗液，给尘螨创造生存条件。研究者说：“把被子摊在床上，里边的潮湿气体很快就会干燥，而外部的湿气又无法进入，各类螨虫会脱水而死。”');
INSERT INTO `knowlege` VALUES (14, '平日小赌赶走抑郁', '赌徒比常人心理更健康。研究人员发现，年龄超过65岁的人参加适度的赌博游戏，比如每周去一次赛马场，他们的大脑会更加活跃，善于与人交流。上岁数的人，在网上玩点在线扑克游戏或者电子赌博游戏，能有效排解抑郁，阻止大脑早衰。');

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `identify` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '123456', 1);
INSERT INTO `user` VALUES (2, '李四', '123456', 2);
INSERT INTO `user` VALUES (3, '王五', '123456', 2);
INSERT INTO `user` VALUES (4, '王英', '123456', 2);
INSERT INTO `user` VALUES (5, '李建伟', '123456', 2);
INSERT INTO `user` VALUES (6, '刘惠军', '123456', 2);
INSERT INTO `user` VALUES (7, '毛富强', '123456', 2);
INSERT INTO `user` VALUES (9, 'admin', '123456', 3);
INSERT INTO `user` VALUES (10, 'ddd', '123', 1);

SET FOREIGN_KEY_CHECKS = 1;
