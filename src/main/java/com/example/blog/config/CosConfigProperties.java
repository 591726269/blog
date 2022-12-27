package com.example.blog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wuzp
 * @date 2022/12/22 14:19
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "upload.cos")
public class CosConfigProperties {
    private String url;

    private String secretId;

    private String secretKey;

    private String region;

    private String bucketName;
}
