package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.dao.ClientDao;
import io.renren.entity.ClientEntity;
import io.renren.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clientService")
public class ClientServiceImpl extends ServiceImpl<ClientDao, ClientEntity> implements ClientService {

    @Override
    public ClientEntity getByClientName(String name) {
        ClientEntity entity = this.getOne(new QueryWrapper<ClientEntity>().eq("client_name",name));
        return entity;
    }
}
