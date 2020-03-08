package org.lee.springcloud.client;

import org.lee.springcloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "springcloud-ms-user"/*, url = "127.0.0.1:7000"*/) //url指定请求服务的主机
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "get", method = RequestMethod.GET)
    User find(@RequestParam Map<String, Object> params);
}
