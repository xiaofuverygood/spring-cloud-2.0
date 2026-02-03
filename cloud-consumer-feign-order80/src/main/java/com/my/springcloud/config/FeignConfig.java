package com.my.springcloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 配置类
 * @Author fsy
 * @Date 2023/7/4 16:38
 */
@Configuration
public class FeignConfig {

    /**
     * OpenFeign 重试机制
     * @return Bean
     */
    @Bean
    public Retryer retryer() {
        // 第一个参数是多长时间后开启重试机制：这里设置100ms
        // 第二个参数是重试的间隔：这里设置1s一次
        // 第三个参数是最大请求次数：3次 (这个次数是一共的, 也就是最大请求几次, 而不是第一次请求失败后再请求几次)
        return new Retryer.Default(100, 1, 3);
    }

    /**
     * OpenFeign 日志级别
     * @return Bean
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
