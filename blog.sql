/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-08-31 18:24:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `text` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `ip` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `author` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `from_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `article_view` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modify` datetime DEFAULT NULL,
  `sort` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `article_index` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', null, null, '测试', null, null, null, '2018-08-16 17:19:27', null, null, null);
INSERT INTO `article` VALUES ('2', null, null, null, null, null, null, null, '2018-08-16 17:20:49', null, null, null);
INSERT INTO `article` VALUES ('3', null, null, null, null, null, null, null, '2018-08-16 17:22:55', null, null, null);
INSERT INTO `article` VALUES ('4', null, null, null, null, null, null, null, '2018-08-16 17:40:12', null, null, null);
INSERT INTO `article` VALUES ('5', null, null, null, null, null, null, null, '2018-08-16 17:43:22', null, null, null);
INSERT INTO `article` VALUES ('6', null, null, null, null, null, null, null, '2018-08-16 18:01:42', null, null, null);
INSERT INTO `article` VALUES ('7', '<p>123</p>', null, null, '13', '213', null, null, '2018-08-16 18:01:49', null, null, null);
INSERT INTO `article` VALUES ('8', '<p>&nbsp;</p>\n\n<p>点击事件on和onclick 两者之间的区别（很重要）</p>\n\n<p>&nbsp;</p>\n\n<ul>\n	<li>第1种事件&nbsp;<br />\n	<code>$(&#39;.XX&#39;).click(&#39;.xxx&#39;,function() { alert(&#39;xxx&#39;) });</code>&nbsp;\n\n	<hr /></li>\n	<li>第2种事件&nbsp;<br />\n	<code>$(&#39;.XXX&#39;).on(&#39;click&#39;,&#39;.xxx&#39;, function() { alert(&#39;xxx&#39;) })</code></li>\n</ul>\n\n<p>click是点击事件，但是在页面加载完之后，jquery事件新添加的元素，用click的话是无法获取元素的，这个时候要用on去获取元素事件，简单的说页面加载完成时候页面显示的元素可以用on，也可以用click，但是页面加载完成之后后期再追加的元素只能用on。</p>\n\n<p>这两个事件的区别之处在于:&nbsp;<br />\n简单的说页面加载完成时候页面显示的元素（DOM节点已全部加载完）可以用&nbsp;<code>on</code>&nbsp;， 也可以用<code>click</code>&nbsp;，</p>\n\n<p>但是在页面加载完成之后后期再追加元素（DOM节点元素还没完全显示出来）只能用<code>on</code></p>\n\n<blockquote>\n<p>解释一下：</p>\n</blockquote>\n\n<p><code>$(&#39;.AAA&#39;).on(&#39;click&#39;,&#39;.bbb&#39;, function() { alert(&#39;bbb&#39;) })</code>&nbsp;</p>\n\n<p>获取class 为bbb元素的上一级（或父级）元素，选择click的方式，执行回调函数function ()并运行弹出元素bbb,这里的on,元素bbb如果没全部加载出来。没有直接获取到class为bbb的元素，这个时候它就会去找上一级（或父级）的元素，然后在从上一级（或父级）往下接着再执行，就会找到class为bbb的元素了，就触发了点击事件，并执行事件里面的函数啦 ~</p>\n\n<pre>\n\n&nbsp;</pre>\n\n<ol>\n	<li>\n	<p><code>$(&quot;p&quot;).on(&quot;click&quot;,function(){</code></p>\n	</li>\n	<li>\n	<p><code>alert(&quot;段落被点击了。&quot;);</code></p>\n	</li>\n	<li>\n	<p><code>});</code></p>\n	</li>\n</ol>', null, null, '点击事件on和onclick 两者之间的区别', '', null, null, '2018-08-16 18:04:12', null, null, null);
INSERT INTO `article` VALUES ('9', null, null, null, null, null, null, null, '2018-08-17 08:49:06', null, null, null);
INSERT INTO `article` VALUES ('17', '<p>测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试</p>', null, null, '测试测试测试测试测试测试测试测试测试测试测试测试', '', null, null, '2018-08-17 16:07:33', null, null, null);
INSERT INTO `article` VALUES ('18', '<p>测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试</p>', null, null, '测试测试测试测试测试测试测试测试测试测试测试测试', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', null, null, '2018-08-17 16:09:04', null, null, null);
INSERT INTO `article` VALUES ('19', null, null, null, null, null, null, null, '2018-08-17 16:10:12', null, null, null);
INSERT INTO `article` VALUES ('39', null, null, null, null, null, null, null, '2018-08-17 16:49:46', null, null, null);
INSERT INTO `article` VALUES ('40', '<p>测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试</p>', null, null, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', null, null, '2018-08-17 16:49:59', null, null, null);
INSERT INTO `article` VALUES ('41', '<p>测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测</p>', null, null, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测', null, null, '2018-08-17 16:51:29', null, null, null);
INSERT INTO `article` VALUES ('42', '<p>测试测试测试测试测试测试测试测试测试测试</p>', null, null, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试测试测试测试测试测试测试测试测试测试', null, null, '2018-08-17 16:51:40', null, null, null);
INSERT INTO `article` VALUES ('43', null, null, null, null, null, null, null, '2018-08-17 17:20:51', null, null, null);
INSERT INTO `article` VALUES ('44', null, null, null, null, null, null, null, '2018-08-17 17:22:09', null, null, null);
INSERT INTO `article` VALUES ('45', null, null, null, null, null, null, null, '2018-08-17 17:23:35', null, null, null);
INSERT INTO `article` VALUES ('46', null, null, null, null, null, null, null, '2018-08-20 09:23:04', null, null, null);
INSERT INTO `article` VALUES ('47', null, null, null, null, null, null, null, '2018-08-24 09:35:53', null, null, null);
INSERT INTO `article` VALUES ('48', null, null, null, null, null, null, null, '2018-08-27 02:29:16', null, null, null);
INSERT INTO `article` VALUES ('49', null, null, null, null, null, null, null, '2018-08-27 08:21:45', null, null, null);
INSERT INTO `article` VALUES ('50', '<p>测试测试测试测试测试测试测试测试测试测试</p>', null, null, '测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试', '测试测试测试测试测试测试测试测试测试测试', null, null, '2018-08-27 08:37:37', null, null, null);
INSERT INTO `article` VALUES ('51', null, null, null, null, null, null, null, '2018-08-30 08:24:56', null, null, null);

-- ----------------------------
-- Table structure for authority_info
-- ----------------------------
DROP TABLE IF EXISTS `authority_info`;
CREATE TABLE `authority_info` (
  `authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_name` varchar(40) NOT NULL,
  `authority_key` varchar(20) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`authority_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of authority_info
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `article_type` int(11) DEFAULT NULL,
  `content` varchar(450) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', null, '222222222222222222222222222222222222222222222222222222', '123');
INSERT INTO `comment` VALUES ('2', '50', null, '2111111111111111111111111111111111111111111111113', '123');
INSERT INTO `comment` VALUES ('3', '50', null, '111111111111111111111111111111111111111111111123', '123');
INSERT INTO `comment` VALUES ('4', '50', null, '21111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111134', '123');
INSERT INTO `comment` VALUES ('7', '50', null, '1222222223', null);
INSERT INTO `comment` VALUES ('8', '50', null, '2333333333333', null);
INSERT INTO `comment` VALUES ('9', '50', null, '12313312', null);

-- ----------------------------
-- Table structure for comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `comment_reply`;
CREATE TABLE `comment_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `reply_id` int(11) DEFAULT NULL,
  `reply_type` int(11) DEFAULT NULL,
  `content` varchar(450) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of comment_reply
-- ----------------------------
INSERT INTO `comment_reply` VALUES ('1', null, null, null, null, null, null, null);
INSERT INTO `comment_reply` VALUES ('2', null, '1', null, null, '222222222222222222222222222222222222222222222222222222', null, null);
INSERT INTO `comment_reply` VALUES ('3', null, '50', null, null, null, null, null);
INSERT INTO `comment_reply` VALUES ('18', null, '50', null, null, '1233321332', null, null);
INSERT INTO `comment_reply` VALUES ('19', null, '50', null, null, '1233321332', null, null);
INSERT INTO `comment_reply` VALUES ('20', null, '50', null, null, '1233321332', null, null);
INSERT INTO `comment_reply` VALUES ('21', null, '50', '2', null, '1231', '123', null);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `login_password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  `salt` varchar(32) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `remark` varchar(80) DEFAULT NULL,
  `role` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `register_ip` varchar(64) DEFAULT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10015 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('10001', 'admin', '3182d80e8a8e8905ea528ec69517fc76', 'admin', null, '2018-08-31 05:18:09', '2018-08-31 05:18:09', '2018-08-31 05:18:09', '5e6b89df2d61fca87b6e7cfc5bc7c708', null, null, 'user', '123456@163.com', null, null);
INSERT INTO `user_info` VALUES ('10011', 'masuzu', '1ac36807ac3276e91b653c679684ea73', 'masuzu', null, '2018-08-14 17:40:15', '2018-08-14 17:40:15', '2018-08-14 17:40:15', '70fe394c709a8a46b48ca0ce6ad2916f', null, null, 'user', '123@163.com', null, null);
INSERT INTO `user_info` VALUES ('10012', '123', 'ee3827d21f71ea24922b39f591736253', '123', null, '2018-08-16 17:48:49', '2018-08-16 17:48:49', '2018-08-16 17:48:49', 'f342a98b23e09b0ced64833304f9b6f9', null, null, 'user', '21', null, null);
INSERT INTO `user_info` VALUES ('10013', '1', 'a7d1352b5e01d1aa51558228d5641c11', '1', null, '2018-08-29 06:21:52', '2018-08-29 06:21:52', '2018-08-29 06:21:52', '872c887959634e23590743477aa57e0c', null, null, 'user', '1', null, null);
