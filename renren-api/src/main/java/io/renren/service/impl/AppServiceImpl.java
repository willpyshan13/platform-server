package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageQuery;
import io.renren.common.utils.PageUtils;
import io.renren.dao.AppDao;
import io.renren.entity.AppEntity;
import io.renren.service.AppService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("appService")
public class AppServiceImpl extends ServiceImpl<AppDao, AppEntity> implements AppService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AppEntity> page = this.page(
                new PageQuery<AppEntity>().getPage(params),
                new QueryWrapper<>());


        return new PageUtils(page);
    }
}
