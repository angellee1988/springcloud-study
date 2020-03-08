package org.lee.springcloud.config;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.lee.springcloud.client.UserFeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(FeignClientsConfiguration.class)
public class FeignConfig {

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    public UserFeignClient userFeignClient(Client client, Encoder encoder,
                                           Decoder decoder, Contract contract) {
        return Feign.builder().client(client).
                encoder(encoder).
                decoder(decoder)
                .contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("user", "password"))
                .target(UserFeignClient.class, "http://springcloud-ms-user/");

    }
}
