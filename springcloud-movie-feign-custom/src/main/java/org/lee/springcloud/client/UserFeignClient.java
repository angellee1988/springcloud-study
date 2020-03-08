package org.lee.springcloud.client;

import feign.Param;
import feign.RequestLine;
import org.lee.springcloud.config.FeignConfig;
import org.lee.springcloud.config.FeignLogConfig;
import org.lee.springcloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "springcloud-ms-user", configuration = {FeignConfig.class, FeignLogConfig.class })
public interface UserFeignClient {
    /**
     * 使用feign自带注解
     * @param id
     * @return
     */
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}
