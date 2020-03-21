/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package io.renren.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.annotation.Login;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.entity.AppEntity;
import io.renren.form.AppForm;
import io.renren.form.LoginForm;
import io.renren.service.AppService;
import io.renren.service.TokenService;
import io.renren.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;
import java.util.Map;

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


    @PostMapping("upload")
    @ApiOperation("上传app")
    public R upload(@RequestBody AppEntity form) {
        //表单校验
        ValidatorUtils.validateEntity(form);
        form.setUpdate_time(new Date());
        form.setCreate_time(new Date());
        //用户登录
        boolean add = appService.save(form);
        if (add) {
            return R.ok("保存成功");
        } else {
            return R.error("保存失败");
        }
    }

    @GetMapping("list")
    @ApiOperation("app列表")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = appService.queryPage(params);
        return R.ok().put("page",page);
    }

}
