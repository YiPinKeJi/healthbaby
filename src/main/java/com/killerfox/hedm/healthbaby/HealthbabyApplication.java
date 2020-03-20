package com.killerfox.hedm.healthbaby;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.killerfox.hedm.healthbaby.mapper")
@SpringBootApplication
public class HealthbabyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthbabyApplication.class, args);
    }

}
