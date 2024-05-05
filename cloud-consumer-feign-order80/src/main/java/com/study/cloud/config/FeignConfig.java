package com.study.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李京霖
 * @version 2024/5/5 13:46 1.0
 */


@Configuration
public class FeignConfig {


    /**
     * 配置是否进行重试机制
     * @return Retryer
     */
    @Bean
    public Retryer retryer() {
        return Retryer.NEVER_RETRY;
    }


    /**
     * 配置Feign日志记录的级别。
     * <p>
     * 该方法没有参数。
     *
     * @return Logger.Level 返回Feign客户端应使用的日志级别。这里返回的是Logger.Level.FULL，
     *         表示将记录Feign客户端的全量日志，包括请求的HTTP头、请求体、响应的HTTP头和响应体。
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


}
