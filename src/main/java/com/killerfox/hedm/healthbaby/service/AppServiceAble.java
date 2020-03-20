package com.killerfox.hedm.healthbaby.service;

import com.killerfox.hedm.healthbaby.entity.FinishEntity;
import com.killerfox.hedm.healthbaby.entity.ProgressEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface AppServiceAble {

    /**
     * 查询视频列表
     * @param account 用户唯一值
     * @return
     */
    Object getResource(String account);

    /**
     * 用户推出是发送进度
     * @param account
     * @param entity
     * @return
     */
    Object userFinishNotice(String account,ProgressEntity entity);

    /**
     * 完成记录
     * @param account
     * @return
     */
    Object doFinish(FinishEntity account);

    /**
     * 获取最大完成顺序
     * @return
     */
    Object getMaxOrder();

}
