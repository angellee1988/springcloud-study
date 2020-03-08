package org.lee.springcloud.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "springcloud-ms-user", configuration = RibbonConfig.class)
public class TestConfig {
}
