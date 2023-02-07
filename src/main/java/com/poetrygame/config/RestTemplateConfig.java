package com.poetrygame.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zzw
 * @Date: 2023/2/7
 * @Time: 9:17
 * @Description:
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/********************************************
 * 模块名称:
 *   主要功能是做
 *      HttpMessageConverter 对象转换器
 *      ClientHttpRequestFactory 默认是JDK的HttpURLConnection
 *      ResponseErrorHandler 异常处理
 *      ClientHttpRequestInterceptor 请求拦截器
 * @author
 * @date 2021/9/24  15:30
 * @version 2021/9/24  15:30-01    v1.0.0.0
 *******************************************/
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(simpleFactory());
        //添加请求拦截器日志
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        restTemplate.setRequestFactory(simpleFactory());
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        // 响应超时时间20s
        factory.setReadTimeout(20 * 1000);
        // 连接超时10s
        factory.setConnectTimeout(10 * 1000);
        return factory;
    }

}