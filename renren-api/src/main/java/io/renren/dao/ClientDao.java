/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.entity.AppEntity;
import io.renren.entity.ClientEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户端
 *
 * @author will
 */
@Mapper
public interface ClientDao extends BaseMapper<ClientEntity> {
	
}
