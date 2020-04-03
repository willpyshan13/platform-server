/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.controller;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.entity.AppEntity;
import io.renren.entity.ClientEntity;
import io.renren.entity.TokenEntity;
import io.renren.form.AppForm;
import io.renren.service.AppService;
import io.renren.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * app接口
 *
 * @author
 */
@RestController
@RequestMapping("/app")
@Api(tags = "上传接口")
public class AppController {
    @Autowired
    private AppService appService;

    @Autowired
    private ClientService clientService;

    @PostMapping("upload")
    @ApiOperation("上传app")
    public R upload(@RequestBody AppForm form) {
        Long clientId = 0L;
        //先判断是否存在相对应的客户端
        String client = form.getClientId();
        ClientEntity entity = clientService.getByClientName(client);

        if (entity != null) {
            clientId = entity.getClientId();
        } else if (entity == null) {
            entity = new ClientEntity();
            entity.setClientName(client);
            entity.setUpdateTime(System.currentTimeMillis());
            entity.setCreateTime(System.currentTimeMillis());

            boolean success = clientService.save(entity);
            if (success) {
                ClientEntity successEntity = clientService.getByClientName(client);
                clientId = successEntity.getClientId();
            }
        }

        AppEntity appEntity = new AppEntity();
        appEntity.setAppName(form.getAppName());
        appEntity.setChannel(form.getChannel());
        appEntity.setClientId(clientId);
        appEntity.setDownloadUrl(form.getDownloadUrl());
        appEntity.setUpdateLog(form.getUpdateLog());
        appEntity.setVersion(form.getVersion());
        appEntity.setPlatform(form.getPlatform());
        appEntity.setLogoUrl(form.getLogoUrl());
        appEntity.setToken(UUID.randomUUID().toString().replace("-", ""));
        appEntity.setUpdateTime(System.currentTimeMillis());
        appEntity.setCreateTime(System.currentTimeMillis());
        //用户登录
        boolean add = appService.save(appEntity);
        if (add) {
            return R.ok(appEntity.getToken());
        } else {
            return R.error("保存失败");
        }
    }

    @GetMapping("get")
    @ApiOperation("获取应用信息")
    public R getInfo(@RequestParam("token") String token) {
        AppEntity info = appService.queryByToken(token);
        return R.ok(info);
    }

    @GetMapping("list")
    @ApiOperation("app列表")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = appService.queryPage(params);
        return R.ok(page);
    }

    @PostMapping("remove")
    @ApiOperation("删除操作")
    public R deleteApp(@RequestBody Serializable id) {
        if (appService.getById(id) != null) {
            appService.removeById(id);
            return R.ok();
        } else {
            return R.error("查找失败");
        }
    }

    @PostMapping("update")
    @ApiOperation("更新app操作")
    public R updateApp(@RequestBody AppEntity form) {
        boolean success = appService.saveOrUpdate(form);
        if (success) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @GetMapping("client/list")
    @ApiOperation("平台列表")
    public R clientList() {
        List<ClientEntity> list = clientService.list();

        return R.ok().put("page", list);
    }


}
