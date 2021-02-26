package org.lee.springcloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "storage-server"/*, url = "127.0.0.1:7000"*/) //url指定请求服务的主机
public interface StorageFeignClient {

    @RequestMapping(value = "storage/decrease", method = RequestMethod.GET)
    String decrease(@RequestParam("productId") Integer productId,
                    @RequestParam("count") Integer count);
}
