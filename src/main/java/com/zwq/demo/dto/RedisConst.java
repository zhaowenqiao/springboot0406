package com.zwq.demo.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConst {

    public RedisConst(){}

    private String host;
    private String port ;
    private String password;

}
