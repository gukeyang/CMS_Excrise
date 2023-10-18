-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2023-10-18 19:04:23
-- 服务器版本： 8.0.24
-- PHP 版本： 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `ujcms-table`
--
CREATE DATABASE IF NOT EXISTS `ujcms-table` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ujcms-table`;

-- --------------------------------------------------------

--
-- 表的结构 `characteristic`
--

CREATE TABLE `characteristic` (
  `id` int NOT NULL,
  `chTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `chContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章内容',
  `firstTarget` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属一级目录',
  `secondTarget` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属二级目录',
  `state` int DEFAULT '0' COMMENT '文章审核状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `characteristic`
--

INSERT INTO `characteristic` (`id`, `chTitle`, `chContent`, `firstTarget`, `secondTarget`, `state`) VALUES
(1, '虚拟养鸡', '虚拟仿真666', '虚拟仿真', '虚拟养鸡', 0),
(2, '虚拟养猪', '远程操作666', '虚拟仿真', '虚拟养猪', 0),
(3, '远程饲养', '阿里巴巴', '远程互动', '饲养远程', 0),
(4, '远程加工', '数字标本', '远程互动', '加工远程', 0);

-- --------------------------------------------------------

--
-- 表的结构 `examination`
--

CREATE TABLE `examination` (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试题名称',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试题内容',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试题正确答案',
  `classify` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试题分类'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- 表的结构 `first`
--

CREATE TABLE `first` (
  `first_Id` int NOT NULL,
  `firstTargetName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `first`
--

INSERT INTO `first` (`first_Id`, `firstTargetName`) VALUES
(1, '首页'),
(2, '新闻公告'),
(3, '中心概述'),
(4, '虚拟仿真'),
(5, '远程互动'),
(6, '视频教学'),
(7, '在线考试');

-- --------------------------------------------------------

--
-- 表的结构 `loginlog`
--

CREATE TABLE `loginlog` (
  `id` int NOT NULL,
  `ipv4` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date` varchar(6) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- 表的结构 `manager`
--

CREATE TABLE `manager` (
  `id` int NOT NULL,
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userAuthority` int DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `manager`
--

INSERT INTO `manager` (`id`, `admin`, `password`, `username`, `userAuthority`, `email`) VALUES
(1, 'admin', 'admin', '河南科技学院', 1, NULL),
(2, '3056726345@qq.com', '12345677890', 'U平台567808号', 1, '3056726345@qq.com'),
(3, '1090649095@qq.com', 'zhao123456', 'U平台187043号', NULL, '1090649095@qq.com');

-- --------------------------------------------------------

--
-- 表的结构 `notice`
--

CREATE TABLE `notice` (
  `id` int NOT NULL,
  `notice_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `notice_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '内容',
  `notice_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发布时间',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公告审核状态',
  `first_target` varchar(255) DEFAULT NULL COMMENT '一级目录',
  `html_url` varchar(255) DEFAULT NULL COMMENT '地址'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `notice`
--

INSERT INTO `notice` (`id`, `notice_title`, `notice_content`, `notice_time`, `status`, `first_target`, `html_url`) VALUES
(7, '我校组织参加教育部2023年高校实验室安全检查培训会', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1656652146468904962', '中心要闻', '7.html'),
(8, '我校召开国家重点研发计划项目子课题推进会', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1656652146468904962', '中心要闻', '8.html'),
(13, '我校学生获2023年“中华杯•太酷”大学生毕业季服装设计大赛状元', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1656652146468904962', '中心要闻', '13.html'),
(15, '副校长胡铁柱巡查2023年硕士研究生复试现场', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1656652146468904962', '中心要闻', '15.html'),
(16, ' 我校学生工作项目获省学生工作优秀成果奖', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1656652146468904962', '中心要闻', '16.html'),
(17, '我校在第十三届全国大学生数学竞赛决赛中获得优异成绩', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1656652146468904962', '中心要闻', '17.html'),
(18, '我校举行校党委理论学习中心组（扩大）学习会', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1656652146468904962', '中心要闻', '18.html'),
(19, ' 校纪委书记贺杰一行赴西北10余所高校调研交流', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1656652146468904962', '中心要闻', '19.html'),
(20, '我校与沈丘县人民政府签订产学研战略合作协议', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1656652146468904962', '中心要闻', '20.html'),
(21, '校医院荣获“新乡市三八红旗集体”荣誉称号', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1656652146468904962', '中心要闻', '21.html'),
(24, '[宣传部]  收视通知', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018726730117122', '公告通知', '24.html'),
(25, '[实验管理中心]  关于开展实验室安全检查的通知', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018726730117122', '公告通知', '25.html'),
(26, '[教务处]  关于举办法律伴我成长征文大赛的通知', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018726730117122', '公告通知', '26.html'),
(27, ' [教务处]  关于第九届“东方财富杯”大学生金融精英挑战赛', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018726730117122', '公告通知', '27.html'),
(28, '[团委]  关于开展2023年“国家安全教育日”主题班团日活动的通知', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018726730117122', '公告通知', '28.html'),
(29, '[教务处]  关于举办2023年艺林植物种类识别大赛的通知', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018726730117122', '公告通知', '29.html'),
(31, '[教务处]  关于举办“我的专业我代言”PPT展示大赛的通知', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018726730117122', '公告通知', '31.html'),
(32, '[科技处]  关于推荐第三届全国创新争先奖河南候选人的预通知', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018726730117122', '公告通知', '32.html'),
(33, '[教务处]  河南科技学院关于2023年本科师范生教育教学能力考核工作通知', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018726730117122', '公告通知', '33.html'),
(34, '河南实验中心考试题测', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018959312662530', '在线测试', '34.html'),
(35, '显微数码互动教学实验室', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018959312662530', '师生互动', '35.html'),
(36, '期末考试模拟考试平台', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018959312662530', '在线测试', '36.html'),
(37, '模拟电子技术仿真指导', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-03-09-08-25', '1657018959312662530', '师生互动', '37.html'),
(38, '机构简介', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-04-22', '1657018959312662530', '学院概括', '456784913.html'),
(59, '畜牧兽医现代教育技术研发与应用教学团队小组', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-05-10-03-13', '1657018959312662530', '中心要闻', '4028c471880496d301880496d3980000.html'),
(60, '中心概况', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-05-10-03-24', '1657018959312662530', '学院概括', '4028c471880496d301880497e88e0001.html'),
(61, '特色与创新', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-05-10-03-46', '1657018959312662530', '学院概括', '4028c471880496d3018804983e3e0002.html'),
(62, '建设目标', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-05-10-03-07', '1657018959312662530', '学院概括', '4028c471880496d3018804988f550003.html'),
(63, '社会责任', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-05-10-03-07', '1657018959312662530', '学院概括', '4028c471880496d30188049a64eb0004.html'),
(64, '养殖生产模拟视频教学', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-05-10-03-35', '1657018959312662530', '虚拟养猪', '4028c471880496d30188049ad3690005.html'),
(65, '养猪场虚拟仿真实验室', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-05-10-03-57', '1657018959312662530', '虚拟养猪', '4028c471880496d30188049b29010006.html'),
(66, '养猪学远程互动教学实验室', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-05-10-03-40', '1657018959312662530', '猪场远程', '4028c471880496d30188049bd1ca0007.html'),
(67, '手术示范互动教学实验室', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-05-10-03-17', '1657018959312662530', '精品课程', '4028c471880496d30188049c61db0008.html'),
(68, '显微数码互动教学实验室', '<p><span class=\"ql-size-20px\">4月12日下午，党委办公室在行政楼1209室召开专题会议传达学习学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神。会议由党委办公室主任赵长春主持。 会上，党委办公室副主任张永波传达了学校学习贯彻习近平新时代中国特色社会主义思想主题教育工作会议精神和校</span></p>', '2023-05-10-03-49', '1657018959312662530', '在线课堂', '4028c471880496d30188049dc7b60009.html'),
(69, '期末考试模拟考试平台', '期末考试模拟考试平台', '2023-06-09-04-47', '1657018959312662530', '在线测试', '4028c471889f51a401889f51a4aa0000.html'),
(70, '期末考试模拟考试平台', '期末考试模拟考试平台', '2023-06-09-04-48', '1657018959312662530', '在线测试', '4028c471889f51a401889f5291f60001.html'),
(71, '期末考试模拟考试平台', '期末考试模拟考试平台', '2023-06-09-04-49', '1657018959312662530', '在线测试', '4028c471889f51a401889f5295cb0002.html'),
(72, '期末考试模拟考试平台', '期末考试模拟考试平台', '2023-06-09-04-50', '1657018959312662530', '在线测试', '4028c471889f51a401889f5298150003.html'),
(73, '期末考试模拟考试平台', '期末考试模拟考试平台', '2023-06-09-04-50', '1657018959312662530', '在线测试', '4028c471889f51a401889f529a6d0004.html'),
(74, '期末考试模拟考试平台', '期末考试模拟考试平台', '2023-06-09-04-51', '1657018959312662530', '在线测试', '4028c471889f51a401889f529cdc0005.html'),
(75, '期末考试模拟考试平台', '期末考试模拟考试平台', '2023-06-09-04-52', '1657018959312662530', '在线测试', '4028c471889f51a401889f529f090006.html'),
(76, '模拟电子技术仿真指导', '期末考试模拟考试平台', '2023-06-09-04-18', '1657018959312662530', '师生互动', '4028c471889f51a401889f53072e0007.html'),
(77, '模拟电子技术仿真指导', '期末考试模拟考试平台', '2023-06-09-04-19', '1657018959312662530', '师生互动', '4028c471889f51a401889f530a460008.html'),
(78, '模拟电子技术仿真指导', '期末考试模拟考试平台', '2023-06-09-04-20', '1657018959312662530', '师生互动', '4028c471889f51a401889f530c9e0009.html'),
(79, '模拟电子技术仿真指导', '期末考试模拟考试平台', '2023-06-09-04-20', '1657018959312662530', '师生互动', '4028c471889f51a401889f530f2b000a.html'),
(80, '模拟电子技术仿真指导', '期末考试模拟考试平台', '2023-06-09-04-21', '1657018959312662530', '师生互动', '4028c471889f51a401889f5310e5000b.html'),
(81, '1111', '1111', '2023-08-02-11-19', '0', '1111', 'ff80808189b43ffd0189b43ffd5e0000.html'),
(82, '1111', '11111', '2023-08-02-11-36', '0', '111111', 'ff80808189b43ffd0189b4403d7c0001.html'),
(83, '1111', '1111', '2023-08-02-05-26', '0', '1111', 'ff80808189b43ffd0189b598534d0002.html');

-- --------------------------------------------------------

--
-- 表的结构 `object_item`
--

CREATE TABLE `object_item` (
  `id` bigint NOT NULL,
  `objectName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `size` bigint DEFAULT NULL,
  `htitle` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `hpart` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 转存表中的数据 `object_item`
--

INSERT INTO `object_item` (`id`, `objectName`, `size`, `htitle`, `hpart`) VALUES
(1656652146468904962, '2023-05-11&&1683811625300.jpg', 347037, '111', '11'),
(1657018726730117122, '2023-05-12&&1683899023404.png', 14304068, '阿萨', '发生的'),
(1657018959312662530, '2023-05-12&&1683899080326.jpg', 322439, '的似的是的', '大苏打实打实'),
(1657019180415397889, '2023-05-12&&1683899131597.png', 14304068, '请问请问', '全额万绮雯'),
(1657019773074747394, '2023-05-12&&1683899274249.jpg', 1150755, '请问请问', '请问请问'),
(1657019924157771778, '2023-05-12&&1683899310437.jpg', 292137, '反对法地方', '实打实打算'),
(1657020644336545793, '2023-05-12&&1683899482060.jpg', 292137, '1212', '1213'),
(1657020801480339458, '2023-05-12&&1683899519522.jpg', 993836, '实打实的', '大苏打'),
(1657020862952058882, '2023-05-12&&1683899534233.jpg', 445561, '驱蚊器', '驱蚊器'),
(1657022232589447169, '2023-05-12&&1683899860725.jpg', 347037, '为其我去', '钱钱钱'),
(1657022403981291521, '2023-05-12&&1683899901658.jpg', 355660, '二位', '请问请问ew'),
(1657227474299969537, '2023-05-13&&1683948794051.jpg', 993836, '请问请问', '千万千万'),
(1657227542469992450, '2023-05-13&&1683948810488.jpg', 203583, '请问请问', '的似的是的'),
(1657227589504917505, '2023-05-13&&1683948821681.jpg', 355660, '请问请问', '啊大苏打'),
(1657227637361926145, '2023-05-13&&1683948833070.jpg', 701916, '请问请问', '撒大苏打'),
(1664212780979007489, '2023-06-01&&1685614221009.jpg', 439615, 'dss', 'asas');

-- --------------------------------------------------------

--
-- 表的结构 `organizationmanagementfir`
--

CREATE TABLE `organizationmanagementfir` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `contacts` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `organization` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- 表的结构 `organizationmanagementsec`
--

CREATE TABLE `organizationmanagementsec` (
  `id` int NOT NULL COMMENT 'id',
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `contacts` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '联系人',
  `organization_id` int DEFAULT NULL COMMENT '上级组织id',
  `organization` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组织'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- 表的结构 `part_m`
--

CREATE TABLE `part_m` (
  `id` bigint NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `part` bigint DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 转存表中的数据 `part_m`
--

INSERT INTO `part_m` (`id`, `title`, `picture`, `part`, `url`) VALUES
(1633730671978741762, '1111', '1111', 1111, NULL),
(1633806263680618497, 'sad', 'asd', 132, NULL),
(1633809769677819905, 'sad', 'asd', 13, NULL),
(1633811812152832001, 'sadas', 'sdas', 16, NULL),
(1633825674257903617, '1', '1', 1, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `part_s`
--

CREATE TABLE `part_s` (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 转存表中的数据 `part_s`
--

INSERT INTO `part_s` (`id`, `name`, `status`) VALUES
(1, 'LOGO', 'LOGO'),
(2, 'CODE', '1111'),
(3, 'SIDEA', '侧边图A'),
(4, 'Rotation', '轮播图'),
(5, '中心要闻', '中心要闻'),
(1656566442518839298, 'sss', 'sss'),
(1656569662888701954, 'sad', 'asd');

-- --------------------------------------------------------

--
-- 表的结构 `picture`
--

CREATE TABLE `picture` (
  `id` bigint NOT NULL,
  `imgPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '目录',
  `imgTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  `imgName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片名字',
  `type` int DEFAULT NULL COMMENT '类型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `picture`
--

INSERT INTO `picture` (`id`, `imgPath`, `imgTime`, `imgName`, `type`) VALUES
(1634093597353435137, 'http://43.138.119.32:9000/carousel/2023-03-10&&轮播图1', '2023-03-10', '轮播图1', 0),
(1634093821111164929, 'http://43.138.119.32:9000/carousel/2023-03-10&&轮播图2', '2023-03-10', '轮播图2', 0),
(1634093847526891521, 'http://43.138.119.32:9000/carousel/2023-03-10&&轮播图3', '2023-03-10', '轮播图3', 0),
(1634097254958481409, 'http://43.138.119.32:9000/carousel/2023-03-10&&logo', '2023-03-10', 'logo', 0),
(1647132153884672002, 'http://43.138.119.32:9000/carousel/2023-04-15&&侧边图C', '2023-04-15', '侧边图C', 0),
(1647132475407433729, 'http://43.138.119.32:9000/carousel/2023-04-15&&侧边图A', '2023-04-15', '侧边图A', 0),
(1647132535704748033, 'http://43.138.119.32:9000/carousel/2023-04-15&&侧边图B', '2023-04-15', '侧边图B', 0),
(1647132564280541186, 'http://43.138.119.32:9000/carousel/2023-04-15&&侧边图D', '2023-04-15', '侧边图D', 0),
(1647132591333801986, 'http://43.138.119.32:9000/carousel/2023-04-15&&侧边图E', '2023-04-15', '侧边图E', 0),
(1647138562600779777, 'http://43.138.119.32:9000/carousel/2023-04-15&&快手', '2023-04-15', '快手', 0),
(1647138585824641025, 'http://43.138.119.32:9000/carousel/2023-04-15&&微博', '2023-04-15', '微博', 0),
(1647141970619580418, 'http://43.138.119.32:9000/carousel/2023-04-15&&抖音', '2023-04-15', '抖音', 0),
(1647144965109374978, 'http://43.138.119.32:9000/carousel/2023-04-15&&gong', '2023-04-15', 'gong', 0),
(1657569021050691586, 'http://43.138.119.32:9000/carousel/2023-05-14&&25185e5ed7174c10a225c9f4091c2fe4', '2023-05-15', '顾客阳台', NULL),
(1657575901294698497, 'http://43.138.119.32:9000/carousel/2023-05-14&&16e45b58184b401391a745c6a2ff35fe', '2023-05-14', '驱蚊器', 0),
(1657579272755945473, 'http://43.138.119.32:9000/carousel/2023-05-14&&78fc39246a304b7e8efaefecaf1c8560', '2023-05-14', '全为', 1),
(1657579414854770689, 'http://43.138.119.32:9000/carousel/2023-05-14&&b829984c3ce9434b94192a8d40351711', '2023-05-15', '顾客阳台', 11);

-- --------------------------------------------------------

--
-- 表的结构 `rolemanagement`
--

CREATE TABLE `rolemanagement` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `describe` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `grade` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- 表的结构 `second`
--

CREATE TABLE `second` (
  `secondId` int NOT NULL,
  `firstId` int DEFAULT NULL,
  `secondTargetName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=REDUNDANT;

--
-- 转存表中的数据 `second`
--

INSERT INTO `second` (`secondId`, `firstId`, `secondTargetName`, `url`) VALUES
(1, 2, '中心要闻', 'sceond1.html'),
(2, 2, '公告通知', 'second2.html'),
(3, 3, '学院概括', 'second3.html'),
(4, 4, '虚拟养猪', 'second4.html'),
(5, 4, '虚拟养鸡', 'second5.html'),
(6, 4, '猪文化馆', 'second6.html'),
(7, 4, '动物标本馆', 'second7.html'),
(8, 4, '病理标本馆', 'second8.html'),
(9, 5, '猪场远程', 'second9.html'),
(10, 5, '肉鸡饲养远程', 'second10.html'),
(11, 5, '肉鸡加工远程', 'second11.html'),
(12, 6, '精品课程', 'second12.html'),
(13, 6, '动物手术视频', 'second13.html'),
(14, 7, '试题库', 'second14.html'),
(15, 7, '在线测试', 'second15.html'),
(16, 7, '师生互动', 'second16.html'),
(17, 2, '政务系统', 'second17.html'),
(18, 3, '学校历史', 'second18.html'),
(19, 7, '在线课堂', 'second19.html');

-- --------------------------------------------------------

--
-- 表的结构 `usergroupmanagement`
--

CREATE TABLE `usergroupmanagement` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `describe` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- 表的结构 `usermanagement`
--

CREATE TABLE `usermanagement` (
  `id` int NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `organization` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `userGroup` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `birthDate` datetime DEFAULT NULL,
  `grade` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- 转储表的索引
--

--
-- 表的索引 `characteristic`
--
ALTER TABLE `characteristic`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `examination`
--
ALTER TABLE `examination`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `first`
--
ALTER TABLE `first`
  ADD PRIMARY KEY (`first_Id`) USING BTREE;

--
-- 表的索引 `loginlog`
--
ALTER TABLE `loginlog`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `object_item`
--
ALTER TABLE `object_item`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `organizationmanagementfir`
--
ALTER TABLE `organizationmanagementfir`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `organizationmanagementsec`
--
ALTER TABLE `organizationmanagementsec`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `part_m`
--
ALTER TABLE `part_m`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `part_s`
--
ALTER TABLE `part_s`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `picture`
--
ALTER TABLE `picture`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `rolemanagement`
--
ALTER TABLE `rolemanagement`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `second`
--
ALTER TABLE `second`
  ADD PRIMARY KEY (`secondId`) USING BTREE;

--
-- 表的索引 `usergroupmanagement`
--
ALTER TABLE `usergroupmanagement`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `usermanagement`
--
ALTER TABLE `usermanagement`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `characteristic`
--
ALTER TABLE `characteristic`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- 使用表AUTO_INCREMENT `examination`
--
ALTER TABLE `examination`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `first`
--
ALTER TABLE `first`
  MODIFY `first_Id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- 使用表AUTO_INCREMENT `loginlog`
--
ALTER TABLE `loginlog`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `manager`
--
ALTER TABLE `manager`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 使用表AUTO_INCREMENT `notice`
--
ALTER TABLE `notice`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- 使用表AUTO_INCREMENT `object_item`
--
ALTER TABLE `object_item`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1686576405489418242;

--
-- 使用表AUTO_INCREMENT `organizationmanagementfir`
--
ALTER TABLE `organizationmanagementfir`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `organizationmanagementsec`
--
ALTER TABLE `organizationmanagementsec`
  MODIFY `id` int NOT NULL AUTO_INCREMENT COMMENT 'id';

--
-- 使用表AUTO_INCREMENT `part_m`
--
ALTER TABLE `part_m`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `part_s`
--
ALTER TABLE `part_s`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1656569662888701955;

--
-- 使用表AUTO_INCREMENT `picture`
--
ALTER TABLE `picture`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1657579414854770690;

--
-- 使用表AUTO_INCREMENT `rolemanagement`
--
ALTER TABLE `rolemanagement`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `second`
--
ALTER TABLE `second`
  MODIFY `secondId` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- 使用表AUTO_INCREMENT `usergroupmanagement`
--
ALTER TABLE `usergroupmanagement`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `usermanagement`
--
ALTER TABLE `usermanagement`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
