# springcloud-study

#Eureka Server 用户认证
引入依赖：
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        
加入配置:
    
security:
  basic:
    enabled: true
  user:
    name: admin
    password: 123456

