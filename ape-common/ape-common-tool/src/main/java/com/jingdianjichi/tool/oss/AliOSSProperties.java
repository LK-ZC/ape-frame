package com.jingdianjichi.tool.oss;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

    private String endpoint;

}
