package org.lee.springcloud.controller;

import org.lee.springcloud.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RestTemplate ribbonTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("user/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://127.0.0.1:7000/" + id, User.class);
    }

    @GetMapping("user/{id}/loadbalance")
    public User findByIdWithLB(@PathVariable Long id) {
        return ribbonTemplate.getForObject("http://springcloud-ms-user/" + id, User.class);
    }

    @GetMapping("user-instance")
    public List<ServiceInstance> userInstance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-ms-user");
        return instances;
    }

    @GetMapping("log-instance")
    public ServiceInstance logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("springcloud-ms-user");
        // 打印当前选择的是哪个节点
        logger.info("serviceId:{}, host:{}, port:{}", serviceInstance.getServiceId(),
                serviceInstance.getHost(), serviceInstance.getPort());
        return serviceInstance;
    }
}
