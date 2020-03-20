package com.killerfox.hedm.healthbaby.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FinishEntity {

    @NotNull(message = "账户名称不为空")
    private String account;
}
