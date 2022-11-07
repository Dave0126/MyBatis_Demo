/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL数据库
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : mybatis_test

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 07/11/2022 21:20:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='部门表';

-- ----------------------------
-- Records of t_dept
-- ----------------------------
BEGIN;
INSERT INTO `t_dept` (`dept_id`, `dept_name`) VALUES (1, 'enseeiht');
INSERT INTO `t_dept` (`dept_id`, `dept_name`) VALUES (2, 'tbs');
INSERT INTO `t_dept` (`dept_id`, `dept_name`) VALUES (3, 'tgu');
COMMIT;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(20) DEFAULT NULL,
  `emp_age` int DEFAULT NULL,
  `emp_gender` varchar(1) DEFAULT NULL,
  `emp_email` varchar(50) DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COMMENT='员工表';

-- ----------------------------
-- Records of t_emp
-- ----------------------------
BEGIN;
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (1, 'gdai', 24, '男', 'gdai@gdai.com', 3);
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (2, 'tom', 22, '男', 'tom@tom.com', 1);
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (3, 'enzo', 21, '男', 'enzo@enzo.com', 1);
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (4, 'theo', 22, '男', 'theo@theo.com', 1);
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (5, 'amina', 23, '女', 'amina@amina.com', 2);
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (6, 'clement', 21, '男', 'clement@clement.com', 1);
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (7, 'calioppe', 22, '女', 'calioppe@calioppe.com', 1);
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (8, 'david', 22, '男', 'david@david.com', 1);
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (9, 'alex', 23, '男', 'alex@alex.com', 2);
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (14, 'calioppe', 22, '女', 'calioppe@calioppe.com', 1);
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (15, 'david', 22, '男', 'david@david.com', 1);
INSERT INTO `t_emp` (`emp_id`, `emp_name`, `emp_age`, `emp_gender`, `emp_email`, `dept_id`) VALUES (16, 'alex', 23, '男', 'alex@alex.com', 2);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='test';

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` (`id`, `username`, `password`, `age`, `gender`, `email`) VALUES (1, 'gdai', 'admin', 23, '男', 'admin@admin.con');
INSERT INTO `t_user` (`id`, `username`, `password`, `age`, `gender`, `email`) VALUES (2, 'admin', 'admin', 23, '男', 'admin@admin.con');
INSERT INTO `t_user` (`id`, `username`, `password`, `age`, `gender`, `email`) VALUES (3, 'tom', '123456', 22, '男', 'tom@tom.com');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
