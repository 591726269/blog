package com.example.blog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * qq配置属性
 * @author Wuzp
 * @date 2022/12/22 14:26
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "qq")
public class QQConfigProperties {
    /**
     * QQ appId
     */
    private String appId;

    /**
     * 校验token地址
     */
    private String checkTokenUrl;

    /**
     * QQ用户信息地址
     */
    private String userInfoUrl;
}
