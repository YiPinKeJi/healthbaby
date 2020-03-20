package com.killerfox.hedm.healthbaby.mapper;


import com.killerfox.hedm.healthbaby.entity.ProgressEntity;
import com.killerfox.hedm.healthbaby.entity.ResourceEntity;
import com.killerfox.hedm.healthbaby.entity.UserNumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {

    List<ResourceEntity> getResourceList(String account);

    List<UserNumber> getUserNumber();

    boolean modUserNumber(@Param("id") Integer id, @Param("value") Long value);

    boolean modProgress(ProgressEntity progress);

    boolean addProgress(ProgressEntity progress);

    ProgressEntity getProgress(@Param("account") String account, @Param("resource_id") Integer resource_id);

}
