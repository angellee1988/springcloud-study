package org.lee.springcloud.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 为feign添加拦截器
 *
 * 一些接口需要进行Http Basic的认证后才能调用
 */
@Configuration
public class FeignInterceptorConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }
}
