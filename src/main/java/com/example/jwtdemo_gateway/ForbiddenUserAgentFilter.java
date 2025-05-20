package com.example.jwtdemo_gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ForbiddenUserAgentFilter implements GlobalFilter, Ordered {

    private static final List<String> REJECTED_USER_AGENTS = List.of("curl", "the bad sherif");

    @Override
    public Mono<Void> filter(final ServerWebExchange exchange, final GatewayFilterChain chain) {
        final String userAgent = exchange.getRequest().getHeaders().getFirst("User-Agent");

        if (userAgent != null && isRejected(userAgent)) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    private boolean isRejected(final String userAgent) {
        final String uaLower = userAgent.toLowerCase();
        return REJECTED_USER_AGENTS.stream().anyMatch(uaLower::contains);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
