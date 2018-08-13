/*
 Navicat Premium Data Transfer

 Source Server         : currierbrother
 Source Server Type    : MySQL
 Source Server Version : 50547
 Source Host           : localhost:3306
 Source Schema         : currierbrother

 Target Server Type    : MySQL
 Target Server Version : 50547
 File Encoding         : 65001

 Date: 13/08/2018 09:15:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dailyorder
-- ----------------------------
DROP TABLE IF EXISTS `dailyorder`;
CREATE TABLE `dailyorder`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `latintude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `longtitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `servicetime` int(11) DEFAULT NULL,
  `endtime` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dailyorder
-- ----------------------------
INSERT INTO `dailyorder` VALUES (1, NULL, '2018-08-13 00:05:23', '200', '350', NULL, 0, 400);
INSERT INTO `dailyorder` VALUES (2, NULL, '2018-08-12 20:40:49', '440', '436', NULL, 300, 305);
INSERT INTO `dailyorder` VALUES (3, NULL, '2018-08-12 20:40:49', '214', '394', NULL, 307, 310);
INSERT INTO `dailyorder` VALUES (4, NULL, '2018-08-12 20:40:39', '476', '483', NULL, 315, 325);
INSERT INTO `dailyorder` VALUES (5, NULL, '2018-08-12 20:40:49', '352', '487', NULL, 326, 337);
INSERT INTO `dailyorder` VALUES (6, NULL, '2018-08-12 20:40:49', '230', '197', NULL, 338, 349);
INSERT INTO `dailyorder` VALUES (7, NULL, '2018-08-12 20:40:49', '175', '239', NULL, 350, 351);
INSERT INTO `dailyorder` VALUES (8, NULL, '2018-08-12 20:40:49', '133', '202', NULL, 352, 363);
INSERT INTO `dailyorder` VALUES (9, NULL, '2018-08-12 20:40:49', '328', '458', NULL, 364, 375);
INSERT INTO `dailyorder` VALUES (10, NULL, '2018-08-12 20:40:49', ' 25', '499', NULL, 376, 387);

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `im` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (1, '123', '计算机视觉', NULL, 'Xiaomi');
INSERT INTO `feedback` VALUES (10, '123', '计算机视觉', 1, 'Xiaomi');
INSERT INTO `feedback` VALUES (11, '123', '我的软件博大精深', 1, 'Xiaomi');
INSERT INTO `feedback` VALUES (12, '123', '好的未来', 1, 'Xiaomi');
INSERT INTO `feedback` VALUES (13, '123', '112', 1, 'x');
INSERT INTO `feedback` VALUES (14, '', '132312131', 8, 'samsung');
INSERT INTO `feedback` VALUES (15, '123', '不错', 1, 'alps');
INSERT INTO `feedback` VALUES (16, '123', '把', 1, 'alps');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_location` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `order_num` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `usertel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idcard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `orderid` int(11) DEFAULT NULL,
  `endlocation` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for push
-- ----------------------------
DROP TABLE IF EXISTS `push`;
CREATE TABLE `push`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `push_id_uindex`(`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of push
-- ----------------------------
INSERT INTO `push` VALUES (1, '快递小哥快递员助手更新了', '快递小哥在360APP市场已经上线，快来更新吧！！！', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533143141463&di=d651f021558ba7c9989dac61bf148b48&imgtype=0&src=http%3A%2F%2Fm.365azw.com%2FAttachments%2Fshare%2F201410%2F5437938814de5.jpg', '2018-08-01 22:18:14');
INSERT INTO `push` VALUES (2, '你有一个新快递！', '你有新的快递代签收，请赶快到快递点进行签收！！', 'http://img3.imgtn.bdimg.com/it/u=3050177090,577642825&fm=200&gp=0.jpg', '2018-08-02 00:31:11');
INSERT INTO `push` VALUES (3, '今天高温预警！！', '浙江省嘉兴市气象局发布高温橙色预警，请快递员注意安全！！', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=419823922,2201936832&fm=27&gp=0.jpg', '2018-08-02 01:08:51');
INSERT INTO `push` VALUES (4, '浙江省嘉兴台风来袭！', '1945年-2015年，共有44个热带气旋登陆浙江省，其中以热带低压强度登陆的有2个，以热带风暴级及以上强度登陆的有42个（年均0.59个），在全国各沿海省份中位列第五。从年份分布来看，1945-2015的71年间，有36个年份无台风登陆浙江，并列为历年最少，其中1962-1971年为最长空台期，达10年，1952年有1个台风以热带低压级登陆浙江，为历年次少；2004年有3个台风登陆浙江，为历年最多，1972年、1974年、1989年、2000年、2005年和2007年都有2个台风登陆浙江，并列为历年次多。从登陆地点分布来看，台州、温州、宁波、舟山、嘉兴5个沿海城市均有台风登陆记录，其中以台州市最多（19个，年均0.27个），嘉兴市最少（2个，年均0.03个）。从登陆强度分布来看，各强度均有登录记录，其中以台风级登陆的次数最多（16次），以强热带风暴级登陆的次数次多（11次）。登陆浙江省的最强台风为2006年第8号台风“桑美”，登陆时风力为17级（60m/s，920hPa）。从登陆月份分布来看，1-4月和11-12月无台风登陆记录，浙江省台风季期间为5月27日-10月7日，其中以7-8月最为集中，约占72%。', 'http://5322329.s21i.faiusr.com/4/ABUIABAEGAAg-Yn1zAUo3evC7QEwuAQ46gI.png', '2018-08-02 01:10:03');

-- ----------------------------
-- Table structure for ticketsystem
-- ----------------------------
DROP TABLE IF EXISTS `ticketsystem`;
CREATE TABLE `ticketsystem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `head` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `location` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `identity` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `usertel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idcard` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `imkey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '123', '123', '男', '20180801\\aadb8b21dc9a79e9bb3b1ecf8a2ec82c.png', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for userloginhistory
-- ----------------------------
DROP TABLE IF EXISTS `userloginhistory`;
CREATE TABLE `userloginhistory`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `logindate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for userscan
-- ----------------------------
DROP TABLE IF EXISTS `userscan`;
CREATE TABLE `userscan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startlocation` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ordernum` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `usertel` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `idcard` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userid` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `endlocation` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userscan
-- ----------------------------
INSERT INTO `userscan` VALUES (1, '株洲', '5441564665', '徐易杰', '1737413128', '430223199711157474', '2', '颐和园路5号北京大学镜春园78号院附近', '2018-08-05 00:15:38', 120.768564, 30.755759);
INSERT INTO `userscan` VALUES (2, '长沙', '421313213', '毛泽东', '1454565615', '430223199711157474', '0', '十三陵镇西山口村', '2018-08-08 00:15:38', 120.76896, 30.745759);
INSERT INTO `userscan` VALUES (3, '湘潭', '646363553', '蒋介石', '1424231341421', '430223199711157474', '1', '颐和园路5号北京大学逸夫苑', '2018-08-04 00:15:38', 120.728564, 30.750759);
INSERT INTO `userscan` VALUES (4, '张家界', '253252352', '习近平', '3132232', '430223199711157474', '0', '广顺南大街望京园401号', '2018-08-08 00:15:38', 120.768564, 30.755759);
INSERT INTO `userscan` VALUES (5, '成州', '4123125123', '邓小平', '24124214', '430223199711157474', '0', '中国普天汽车充电站', '2018-08-08 00:15:38', 120.868564, 30.555759);
INSERT INTO `userscan` VALUES (6, '衡阳', '5436734562', '周恩来', '232131', '430223199711157474', '1', '易达新能汽车充电站(悠乐汇西', '2018-08-08 00:15:38', 120.528564, 30.355759);
INSERT INTO `userscan` VALUES (7, '洛杉矶', '53256234254', '我是大学生', '2313213', '430223199711157474', '0', '阜通西大街16号院', '2018-08-08 00:15:38', 120.568564, 30.855759);
INSERT INTO `userscan` VALUES (8, '旧金山', '123213124234', 'Dady', '312314124', '430223199711157474', '0', '广顺北大街33号(地下车库B1、B3)', '2018-08-08 00:15:38', 120.668564, 30.055759);

SET FOREIGN_KEY_CHECKS = 1;
