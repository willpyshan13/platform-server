-- 用户表
CREATE TABLE `tb_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) COMMENT '密码',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- 用户Token表
CREATE TABLE `tb_token` (
  `user_id` bigint NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime COMMENT '过期时间',
  `update_time` datetime COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- 用户Token表
CREATE TABLE `tb_app` (
                          `app_id` bigint NOT NULL AUTO_INCREMENT,
                          `app_name` varchar(255) NOT NULL COMMENT 'appName',
                          `version` varchar(255) NOT NULL COMMENT 'version',
                          `platform` varchar(255) NOT NULL COMMENT 'platform',
                          `channel` varchar(255) NOT NULL COMMENT 'channel',
                          `client_id` bigint NOT NULL COMMENT 'client_id',
                          `download_url` varchar(255) NOT NULL COMMENT 'downloadUrl',
                          `logo_url` varchar(255) NOT NULL COMMENT 'logoUrl',
                          `update_log` varchar(255) NOT NULL COMMENT 'updateLog',
                          `token` varchar(255) NOT NULL COMMENT 'token',
                          `create_time` long COMMENT '创建时间',
                          `update_time` long COMMENT '更新时间',
                          PRIMARY KEY (`app_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tb_app';

-- 用户Token表
CREATE TABLE `tb_client` (
                          `client_id` bigint NOT NULL AUTO_INCREMENT,
                          `client_name` varchar(255) NOT NULL COMMENT 'client_name',
                          `create_time` long COMMENT '创建时间',
                          `update_time` long COMMENT '更新时间',
                          PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tb_client';


-- 账号：13612345678  密码：admin
INSERT INTO `tb_user` (`username`, `mobile`, `password`, `create_time`) VALUES ('mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2020-04-05 22:37:41');