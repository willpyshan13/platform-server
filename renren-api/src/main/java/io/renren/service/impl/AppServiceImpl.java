package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageQuery;
import io.renren.common.utils.PageUtils;
import io.renren.dao.AppDao;
import io.renren.entity.AppEntity;
import io.renren.entity.TokenEntity;
import io.renren.service.AppService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;

@Service("appService")
public class AppServiceImpl extends ServiceImpl<AppDao, AppEntity> implements AppService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String platform = (String) params.get("platform");
        String clientId = (String) params.get("clientId");
        IPage<AppEntity> page = this.page(
                new PageQuery<AppEntity>().getPage(params),
                new QueryWrapper<AppEntity>().eq("platform", platform).and(new Function<QueryWrapper<AppEntity>, QueryWrapper<AppEntity>>() {
                    @Override
                    public QueryWrapper<AppEntity> apply(QueryWrapper<AppEntity> appEntityQueryWrapper) {
                        appEntityQueryWrapper.eq("client_id", clientId);
                        return appEntityQueryWrapper;
                    }
                }).orderByDesc("update_time"));
        return new PageUtils(page);
    }

    @Override
    public AppEntity queryByToken(String token) {
        return this.getOne(new QueryWrapper<AppEntity>().eq("token", token));
    }

}
