package com.example.jwtdemo_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class JwtdemoGatewayApplication {

    public static void main(final String[] args) {
        SpringApplication.run(JwtdemoGatewayApplication.class, args);
    }

    @Bean
    KeyResolver ipKeyResolver() {
        return exchange -> {
            final String ip = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            return Mono.just(ip);
        };
    }


}
