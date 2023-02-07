package com.poetrygame.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: zzw
 * @Date: 2022/12/14
 * @Time: 12:47
 * @Description:
 */
@Component
@Data
@ConfigurationProperties(prefix = "wechat")
public class WeChatConfig {

    private String appid;
    private String appSecret;
}
