package com.killerfox.hedm.healthbaby.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xiayo
 */
@Component
@ConfigurationProperties(prefix = "swagger2")
@Data
public class Swagger2Conf {

    private String title;
    private String description;
    private String version;
    private String path;
    private Boolean enable = false;
}
