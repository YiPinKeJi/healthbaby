package com.killerfox.hedm.healthbaby.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProgressEntity {

    @NotNull(message = "视频id不为空")
    private Integer resource_id;

    @NotNull(message = "完成参数不为空")
    private boolean finish;

    private Integer progress;

    @ApiModelProperty(hidden = true)
    private String account;
}
