/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.form;

import lombok.Data;

/**
 * app表单
 *
 * @author
 */
@Data
public class AppForm {
    /**
     * 用户名
     */
    private String appName;
    /**
     * 版本号
     */
    private String version;
    /**
     * android==1、ios==2
     */
    private String clientId;
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
    private String downloadUrl;
    /**
     * 下载链接
     */
    private String logoUrl;

    /**
     * 更新日志
     */
    private String updateLog;
}
