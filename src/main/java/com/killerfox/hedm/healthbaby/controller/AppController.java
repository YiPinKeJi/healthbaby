package com.killerfox.hedm.healthbaby.controller;

import com.killerfox.hedm.healthbaby.entity.FinishEntity;
import com.killerfox.hedm.healthbaby.entity.ProgressEntity;
import com.killerfox.hedm.healthbaby.service.AppService;
import com.killerfox.hedm.healthbaby.service.AppServiceAble;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@Api(description = "应用接口")
@RequestMapping(value = "/healthbaby")
public class AppController {

    @Resource
    private AppServiceAble appServiceAble;

    @ApiModelProperty(notes = "查询资源列表")
    @GetMapping(value = "/resource/account/{account}")
    public Object getResource(@PathVariable("account") String account){

        Object ret = appServiceAble.getResource(account);
        return ret;
    }

    @ApiModelProperty(notes = "添加进度")
    @PostMapping(value = "/resource/progress/{account}")
    public Object userFinishNotice(@PathVariable("account") String account,
                                   @RequestBody ProgressEntity entity){
        return appServiceAble.userFinishNotice(account, entity);
    }

    @ApiModelProperty(notes = "添加完成视频观看记录")
    @PostMapping(value = "/resource/finish")
    public Object doFinish(@RequestBody FinishEntity entity){

        return appServiceAble.doFinish(entity);
    }

    @ApiModelProperty(notes = "查询当前最大记录")
    @GetMapping(value = "/maxorder")
    public Object getMaxOrder(){

        return appServiceAble.getMaxOrder();
    }
}
