/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.AppEntity;
import io.renren.entity.TokenEntity;

import java.util.Map;

/**
 * app
 *
 * @author
 */
public interface AppService extends IService<AppEntity> {
    PageUtils queryPage(Map<String, Object> params);

    AppEntity queryByToken(String token);
}
