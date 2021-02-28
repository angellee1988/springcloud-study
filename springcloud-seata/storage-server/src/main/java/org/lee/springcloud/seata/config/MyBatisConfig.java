package org.lee.springcloud.seata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.lee.springcloud.seata.dao")
public class MyBatisConfig {
}
