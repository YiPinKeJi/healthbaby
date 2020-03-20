package com.killerfox.hedm.healthbaby.entity;

import lombok.Data;

import javax.annotation.Resource;

@Data
public class ResourceEntity {

    private Integer id;

    private String name;

    private String path;

    private String coverurl;

    private Integer duration;

    private boolean finish;

    private int progress;

}
