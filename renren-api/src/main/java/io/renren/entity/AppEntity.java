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
	private String app_name;
	/**
	 * 版本号
	 */
	private String version;
	/**
	 * android==1、ios==2
	 */
	private int client;
	/**
	 * 渠道
	 */
	private String channel;
	/**
	 * 平台
	 */
	private String platform;
	/**
	 * 下载链接
	 */
	private String download_url;

	/**
	 * 更新日志
	 */
	private String update_log;

	/**
	 * 创建时间
	 */
	private Date create_time;

	/**
	 * 更新时间
	 */
	private Date update_time;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getDownload_url() {
		return download_url;
	}

	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}

	public String getUpdate_log() {
		return update_log;
	}

	public void setUpdate_log(String update_log) {
		this.update_log = update_log;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
}
