/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 应用程序实体类
 *
 * @author will
 */
@Data
@TableName("tb_app")
public class AppEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	private Long appId;
	/**
	 * 用户名
	 */
	private String appName;
	/**
	 * 版本号
	 */
	private String version;
	/**
	 * android、ios
	 */
	private String platform;
	/**
	 * 渠道
	 */
	private String channel;
	/**
	 * 平台
	 */
	private Long clientId;
	/**
	 * 下载链接
	 */
	private String downloadUrl;

	/**
	 * 图标链接
	 */
	private String logoUrl;

	/**
	 * 更新日志
	 */
	private String updateLog;

	/**
	 * 更新日志
	 */
	private String token;

	/**
	 * 创建时间
	 */
	private Long createTime;

	/**
	 * 更新时间
	 */
	private Long updateTime;

}
