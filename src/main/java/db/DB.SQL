/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : gtrust

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2017-01-13 18:03:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_user
-- ----------------------------
DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sso_id` (`sso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for app_user_user_profile
-- ----------------------------
DROP TABLE IF EXISTS `app_user_user_profile`;
CREATE TABLE `app_user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  KEY `FK_USER_PROFILE` (`user_profile_id`),
  CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for example
-- ----------------------------
DROP TABLE IF EXISTS `example`;
CREATE TABLE `example` (
  `EXP_ID` int(11) NOT NULL,
  `EXP_NAME` varchar(100) DEFAULT NULL,
  `EXP_SEX` varchar(5) DEFAULT NULL,
  `EXP_DATE` date DEFAULT NULL,
  `EXP_YN` varchar(1) DEFAULT NULL,
  `INSERT_ID` varchar(20) DEFAULT NULL,
  `INSERT_DATE` datetime DEFAULT NULL,
  `MODIFY_ID` varchar(20) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  `LAST_VERSION` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`EXP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实例';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `name` varchar(50) NOT NULL COMMENT '菜单名',
  `ename` varchar(50) NOT NULL COMMENT '英文菜单名',
  `depth` int(1) NOT NULL COMMENT '菜单深度',
  `url` varchar(20) NOT NULL COMMENT '角色类型',
  `controller` varchar(20) DEFAULT NULL COMMENT '角色类型',
  `method` varchar(20) DEFAULT NULL COMMENT '角色类型',
  `parent_id` int(11) DEFAULT NULL COMMENT '角色类型',
  `use_yn` int(1) NOT NULL COMMENT '使用与否是否可用，"1:启用,2:禁用,9:废弃',
  `sort` varchar(2) NOT NULL COMMENT '排序(同级)',
  `remark` varchar(100) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `name` varchar(50) NOT NULL COMMENT '角色名',
  `status` varchar(2) NOT NULL COMMENT '角色状态',
  `type` varchar(2) NOT NULL COMMENT '角色类型',
  `remark` varchar(50) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `menu_id` int(11) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `LOGIN_NAME` varchar(20) NOT NULL COMMENT '用户编码',
  `USER_NAME` varchar(30) NOT NULL COMMENT '用户名',
  `USER_PWD` varchar(36) NOT NULL COMMENT '用户密码',
  `USER_TEL` varchar(12) DEFAULT NULL COMMENT '用户手机',
  `USER_EMAIL` varchar(30) DEFAULT NULL COMMENT '用户电邮',
  `USER_STATUS` int(11) NOT NULL COMMENT '用户状态 0-初始化 1-正常使用 2-异常',
  `USER_TYPE` varchar(2) DEFAULT NULL,
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '父ID',
  `COMMONS` varchar(100) DEFAULT NULL COMMENT '备注',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `LAST_UPDATE_PWD_DATE` date DEFAULT NULL COMMENT '最后密码修改日',
  `INSERT_ID` int(11) NOT NULL,
  `INSERT_DATE` datetime NOT NULL,
  `MODIFY_ID` int(11) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `IDX_USERS_01` (`LOGIN_NAME`),
  UNIQUE KEY `IDX_USERS_02` (`USER_TEL`),
  UNIQUE KEY `IDX_USERS_03` (`USER_EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Table structure for taccount
-- ----------------------------
DROP TABLE IF EXISTS `taccount`;
CREATE TABLE `taccount` (
  `CUST_NO` varchar(15) NOT NULL COMMENT '账号',
  `AMT` double(10,0) NOT NULL COMMENT '剩余金额',
  `INSERT_ID` varchar(10) NOT NULL,
  `INSERT_DATE` date NOT NULL,
  `MODIFY_ID` varchar(10) DEFAULT NULL,
  `MODIFY_DATE` date DEFAULT NULL,
  PRIMARY KEY (`CUST_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='顾客账号';

-- ----------------------------
-- Table structure for taccount_record
-- ----------------------------
DROP TABLE IF EXISTS `taccount_record`;
CREATE TABLE `taccount_record` (
  `ACCOUNT_NO` varchar(15) NOT NULL COMMENT '账号',
  `ACCOUNT_SEQ` varchar(6) NOT NULL COMMENT '账号操作SEQ',
  `OPER_TYPE` varchar(3) NOT NULL,
  `OPER_REL_ACCOUNT` varchar(255) NOT NULL,
  `OPER_AMT` double NOT NULL,
  `REMI_AMT` double NOT NULL,
  `INSERT_ID` varchar(255) NOT NULL,
  `INSERT_DATE` date NOT NULL,
  PRIMARY KEY (`ACCOUNT_NO`,`ACCOUNT_SEQ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账号金额变更记录';

-- ----------------------------
-- Table structure for tcode
-- ----------------------------
DROP TABLE IF EXISTS `tcode`;
CREATE TABLE `tcode` (
  `CODE_LGROUP` varchar(4) NOT NULL COMMENT '大分类',
  `CODE_MGROUP` varchar(20) NOT NULL COMMENT '中分类',
  `CODE_NAME` varchar(50) DEFAULT NULL COMMENT '分类名',
  `CODE_GROUP` varchar(50) DEFAULT NULL COMMENT '分类组',
  `CODE_TYPE` varchar(20) DEFAULT NULL COMMENT '分类类型',
  `CODE_SORT` int(11) NOT NULL,
  `USE_YN` varchar(1) NOT NULL COMMENT '是否使用',
  `INSERT_ID` varchar(20) NOT NULL,
  `INSERT_DATE` date NOT NULL,
  `CODE_TAG02` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG03` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG04` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG05` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG06` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG07` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG08` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG09` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG10` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG11` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG22` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG13` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG14` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG15` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG16` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG17` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG18` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG19` varchar(20) DEFAULT NULL COMMENT '标签',
  `MODIFY_ID` varchar(20) DEFAULT NULL,
  `MODIFY_DATE` date DEFAULT NULL,
  `CODE_TAG` varchar(20) DEFAULT NULL COMMENT '标签',
  `CODE_TAG01` varchar(20) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`CODE_LGROUP`,`CODE_MGROUP`),
  KEY `IDX_TCODE_01` (`CODE_LGROUP`,`CODE_MGROUP`,`USE_YN`),
  KEY `IDX_TCODE_02` (`CODE_LGROUP`),
  KEY `IDX_TCODE_03` (`CODE_NAME`),
  KEY `IDX_TCODE_04` (`CODE_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TCODE字典表';

-- ----------------------------
-- Table structure for tcode_explain
-- ----------------------------
DROP TABLE IF EXISTS `tcode_explain`;
CREATE TABLE `tcode_explain` (
  `CODE_LGROUP` varchar(4) NOT NULL COMMENT '大分类',
  `CODE_MGROUP` varchar(50) NOT NULL,
  `CODE_NAME` varchar(50) DEFAULT NULL COMMENT '分类名',
  `CODE_GROUP` varchar(50) DEFAULT NULL COMMENT '分类组',
  `CODE_TYPE` varchar(50) DEFAULT NULL COMMENT '分类类型',
  `USE_YN` varchar(1) NOT NULL COMMENT '是否使用',
  `INSERT_ID` varchar(20) NOT NULL,
  `INSERT_DATE` date NOT NULL,
  `CODE_TAG` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG01` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG02` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG03` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG04` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG05` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG06` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG07` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG08` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG09` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG10` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG11` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG22` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG13` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG14` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG15` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG16` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG17` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG18` varchar(50) DEFAULT NULL COMMENT '标签',
  `CODE_TAG19` varchar(50) DEFAULT NULL COMMENT '标签',
  `MODIFY_ID` varchar(20) DEFAULT NULL,
  `MODIFY_DATE` date DEFAULT NULL,
  PRIMARY KEY (`CODE_LGROUP`),
  KEY `IDX_TCODE_EXPLAIN_01` (`CODE_LGROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='TCODE表字段描述/说明';

-- ----------------------------
-- Table structure for tcustomer
-- ----------------------------
DROP TABLE IF EXISTS `tcustomer`;
CREATE TABLE `tcustomer` (
  `CUST_NO` varchar(14) NOT NULL DEFAULT '' COMMENT '顾客编号(年月日+SEQ)',
  `CUST_CODE` varchar(20) NOT NULL COMMENT '顾客编码(登录名)',
  `CUST_NAME` varchar(20) NOT NULL COMMENT '顾客名',
  `CUST_PWD` varchar(36) NOT NULL COMMENT '密码',
  `CUST_TEL` varchar(20) DEFAULT NULL COMMENT '手机',
  `CUST_EMAIL` varchar(20) DEFAULT NULL COMMENT '电子邮箱',
  PRIMARY KEY (`CUST_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='顾客基础信息表';

-- ----------------------------
-- Table structure for terrorlog
-- ----------------------------
DROP TABLE IF EXISTS `terrorlog`;
CREATE TABLE `terrorlog` (
  `ERR_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '错误ID - 主键',
  `ERR_NAME` varchar(255) NOT NULL COMMENT '错误',
  `ERR_TYPE` varchar(50) NOT NULL COMMENT '错误类型',
  `ERR_CLASS` varchar(255) NOT NULL COMMENT '错误促发类',
  `ERR_EXCEPTION` varchar(255) NOT NULL COMMENT '错误异常（简述）',
  `ERR_MSG` varchar(5000) NOT NULL COMMENT '错误描述',
  `ERR_DATE` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '错误日期',
  PRIMARY KEY (`ERR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for titem
-- ----------------------------
DROP TABLE IF EXISTS `titem`;
CREATE TABLE `titem` (
  `item_code` varchar(8) NOT NULL DEFAULT '' COMMENT '商品编码',
  `item_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  PRIMARY KEY (`item_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for titemprice
-- ----------------------------
DROP TABLE IF EXISTS `titemprice`;
CREATE TABLE `titemprice` (
  `item_code` varchar(8) NOT NULL COMMENT '商品编码',
  `unit_code` varchar(3) NOT NULL COMMENT '单件编码',
  `sale_price` double NOT NULL DEFAULT '0' COMMENT '销售价（含税）',
  `sale_cost` double NOT NULL DEFAULT '0' COMMENT '销售价（无税）',
  `sale_vat` double NOT NULL DEFAULT '0' COMMENT '销售税额',
  `sale_rate` double NOT NULL DEFAULT '0' COMMENT '销售税率',
  `buy_price` double NOT NULL DEFAULT '0' COMMENT '采购价（含税）',
  `buy_cost` double NOT NULL DEFAULT '0' COMMENT '采购价（无税）',
  `buy_vat` double NOT NULL DEFAULT '0' COMMENT '采购税额',
  `buy_rate` double NOT NULL DEFAULT '0' COMMENT '采购税率',
  PRIMARY KEY (`item_code`,`unit_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tmenu
-- ----------------------------
DROP TABLE IF EXISTS `tmenu`;
CREATE TABLE `tmenu` (
  `MENU_ID` int(11) NOT NULL COMMENT '菜单ID',
  `MENU_PAGE_URL` varchar(45) DEFAULT NULL COMMENT '菜单页面地址',
  `MENU_NAME` varchar(45) DEFAULT NULL COMMENT '菜单名',
  `CTRL_CLASS` varchar(45) DEFAULT NULL COMMENT '菜单对应的控制类',
  `CTRL_METHOD` varchar(45) DEFAULT NULL COMMENT '菜单对应的控制类方法',
  `MENU_LEVEL` varchar(45) DEFAULT NULL COMMENT '菜单层级',
  `MENU_STATUS` varchar(45) DEFAULT NULL COMMENT '菜单状态',
  `MENU_ORDERBY` varchar(45) DEFAULT NULL COMMENT '菜单排序',
  `P_MENU_ID` int(11) DEFAULT NULL COMMENT '父菜单',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Table structure for tprojectd
-- ----------------------------
DROP TABLE IF EXISTS `tprojectd`;
CREATE TABLE `tprojectd` (
  `PRJ_NO` varchar(14) NOT NULL COMMENT '项目编号',
  `PRJ_SEQ` varchar(3) NOT NULL COMMENT '项目SEQ',
  `PRJ_DNAME` varchar(100) DEFAULT NULL COMMENT '子项目名',
  `PLAN_START_DATE` date NOT NULL COMMENT '计划开始日',
  `PLAN_END_DATE` date NOT NULL COMMENT '计划完成日',
  `DEV_FIN_DATE` date DEFAULT NULL COMMENT '开发完成日',
  `TEST_FIN_DATE` date DEFAULT NULL COMMENT '测试完成日',
  `ONLINE_DATE` date DEFAULT NULL COMMENT '上线时间',
  `PRJ_NOTE` varchar(200) DEFAULT NULL COMMENT '项目描述',
  `KPI_LEVEL` varchar(2) DEFAULT NULL COMMENT 'KPI等级',
  `KPI_REASON` varchar(60) DEFAULT NULL COMMENT 'KPI考核原因',
  `DEV_USER` varchar(20) DEFAULT NULL COMMENT '开发人',
  `DIFFICULT_LEVEL` varchar(2) DEFAULT NULL COMMENT '困难等级',
  `END_STATUS` varchar(8) DEFAULT NULL COMMENT '结果状态',
  `END_NOTE` varchar(100) DEFAULT NULL COMMENT '处理结果-原因说明',
  PRIMARY KEY (`PRJ_NO`,`PRJ_SEQ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目子表';

-- ----------------------------
-- Table structure for tprojectm
-- ----------------------------
DROP TABLE IF EXISTS `tprojectm`;
CREATE TABLE `tprojectm` (
  `PRJ_NO` varchar(14) NOT NULL COMMENT '项目编号(年月日+编号)',
  `PRJ_NAME` varchar(60) NOT NULL COMMENT '项目名称',
  `PLAN_START_DATE` date NOT NULL COMMENT '项目预计开始日',
  `PLAN_END_DATE` date NOT NULL COMMENT '项目预计上线日',
  `ACT_START_DATE` date DEFAULT NULL COMMENT '实际开发日',
  `ACT_END_DATE` date DEFAULT NULL COMMENT '实际完成日',
  `PRJ_NOTE` varchar(200) DEFAULT NULL COMMENT '项目描述',
  `KPI_LEVEL` varchar(2) DEFAULT NULL COMMENT 'KPI考评级别',
  `KPI_REASON` varchar(60) DEFAULT NULL COMMENT 'KPI考评原因',
  PRIMARY KEY (`PRJ_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表';

-- ----------------------------
-- Table structure for tstock
-- ----------------------------
DROP TABLE IF EXISTS `tstock`;
CREATE TABLE `tstock` (
  `wh_code` varchar(3) NOT NULL COMMENT '仓库',
  `item_code` varchar(8) NOT NULL COMMENT '商品编码',
  `unit_code` varchar(3) NOT NULL COMMENT '单件编码',
  `qty` int(11) NOT NULL COMMENT '库存数量',
  `oper_grogram` varchar(20) NOT NULL COMMENT '操作程序',
  `insert_id` varchar(20) NOT NULL,
  `insert_date` date NOT NULL,
  `modify_id` varchar(20) DEFAULT NULL,
  `modify_date` date DEFAULT NULL,
  PRIMARY KEY (`wh_code`,`item_code`,`unit_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tunit
-- ----------------------------
DROP TABLE IF EXISTS `tunit`;
CREATE TABLE `tunit` (
  `item_code` varchar(8) NOT NULL COMMENT '商品编码',
  `unit_code` varchar(3) NOT NULL COMMENT '单件编码',
  `unit_name` varchar(50) NOT NULL COMMENT '单件名',
  PRIMARY KEY (`item_code`,`unit_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tusermenu
-- ----------------------------
DROP TABLE IF EXISTS `tusermenu`;
CREATE TABLE `tusermenu` (
  `USER_ID` int(11) NOT NULL,
  `MENU_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户菜单表';

-- ----------------------------
-- Table structure for tusers
-- ----------------------------
DROP TABLE IF EXISTS `tusers`;
CREATE TABLE `tusers` (
  `USER_ID` int(11) NOT NULL COMMENT '用户编号',
  `USER_CODE` varchar(20) NOT NULL COMMENT '用户编码',
  `USER_TEL` varchar(12) DEFAULT NULL COMMENT '用户手机',
  `USER_EMAIL` varchar(30) DEFAULT NULL COMMENT '用户电邮',
  `USER_PWD` varchar(36) NOT NULL COMMENT '用户密码',
  `USER_NAME` varchar(30) NOT NULL COMMENT '用户名',
  `USER_STATUS` int(11) NOT NULL COMMENT '用户状态 0-初始化 1-正常使用 2-异常',
  `COMMONS` varchar(100) DEFAULT NULL COMMENT '备注',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `LAST_UPDATE_PWD_DATE` date DEFAULT NULL COMMENT '最后密码修改日',
  `INSERT_ID` varchar(20) NOT NULL,
  `INSERT_DATE` datetime NOT NULL,
  `MODIFY_ID` varchar(20) DEFAULT NULL,
  `MODIFY_DATE` datetime DEFAULT NULL,
  `LAST_VERSION` bigint(20) NOT NULL COMMENT '最后更新版本号',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `IDX_USERS_01` (`USER_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for user_profile
-- ----------------------------
DROP TABLE IF EXISTS `user_profile`;
CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Procedure structure for temp
-- ----------------------------
DROP PROCEDURE IF EXISTS `temp`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `temp`()
BEGIN
declare
    i int default 10;
begin
	loop_for :loop
		INSERT INTO `gtrust`.`example`
			(`EXP_ID`,
			`EXP_NAME`,
			`EXP_SEX`,
			`EXP_DATE`,
			`EXP_YN`,
			`INSERT_ID`,
			`INSERT_DATE`,
			`MODIFY_ID`,
			`MODIFY_DATE`,
			`LAST_VERSION`)
			VALUES
			(i,
			i,
			i,
			'20161215',
			1,
			i,
			'20161215',
			i,
			'20161215',
			1);

		set i= i+1;
		if(i>10000) then
			leave loop_for;
		end if;
    end loop;
end;
END
;;
DELIMITER ;
