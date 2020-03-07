package org.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 构建双节点EUreka Server集群
 *
 * java -jar springcloud-eureka-ha-1.0-SNAPSHOT.jar --spring.profiles.active=peer1
 * java -jar springcloud-eureka-ha-1.0-SNAPSHOT.jar --spring.profiles.active=peer2
 *
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
