package com.killerfox.hedm.healthbaby.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.killerfox.hedm.healthbaby.common.Result;
import com.killerfox.hedm.healthbaby.common.ResultCode;
import com.killerfox.hedm.healthbaby.common.exception.BusinessException;
import com.killerfox.hedm.healthbaby.config.GlogbalConfig;
import com.killerfox.hedm.healthbaby.entity.FinishEntity;
import com.killerfox.hedm.healthbaby.entity.ProgressEntity;
import com.killerfox.hedm.healthbaby.entity.ResourceEntity;
import com.killerfox.hedm.healthbaby.entity.UserNumber;
import com.killerfox.hedm.healthbaby.mapper.ResourceMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AppService implements AppServiceAble{

    @Resource
    private GlogbalConfig glogbalConfig;

    @Resource
    private ResourceMapper resourceMapper;

    public Object getResource(String account){

        List<ResourceEntity> ret = resourceMapper.getResourceList(account);

        return Result.success(ret);
    }

    public Object userFinishNotice(String account,ProgressEntity entity){

        entity.setAccount(account);
        ProgressEntity ret = resourceMapper.getProgress(account, entity.getResource_id());
        if(ret == null){
            resourceMapper.addProgress(entity);
        }else{
            resourceMapper.modProgress(entity);
        }

        return Result.success();
    }

    public Object doFinish(FinishEntity entity) {

        List<UserNumber> numberList = resourceMapper.getUserNumber();
        if(numberList == null || numberList.size()<=0){
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
        resourceMapper.modUserNumber(numberList.get(0).getId(), numberList.get(0).getValue()+1);

        return Result.success();
    }

    public Object getMaxOrder(){
        List<UserNumber> numberList = resourceMapper.getUserNumber();
        if(numberList == null || numberList.size()<=0){
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }

        String num = String.format("%06d",numberList.get(0).getValue());

        JSONObject obj = new JSONObject(true);
        obj.put("maxOrder", glogbalConfig.getOrderPerfix()+num);
        return Result.success(obj);
    }
}
