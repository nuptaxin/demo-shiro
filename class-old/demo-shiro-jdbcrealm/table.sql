CREATE DATABASE shiro CHARACTER SET utf8;
USE shiro;
CREATE TABLE users(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	username VARCHAR(40) COMMENT '用户名',
	`password` VARCHAR(40) COMMENT '密码'
);

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'bigbird', '123456');
INSERT INTO `users` VALUES ('2', 'admin', '123');
INSERT INTO `users` VALUES ('3', 'superbird', '123456');