package com.egor.stuff_admin.gateway.filter;

import com.egor.stuff_admin.gateway.model.UserContext;
import com.egor.stuff_admin.gateway.model.UserContextHolder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class UserContextFilter implements GlobalFilter {
    private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        if (exchange.getRequest()
                .getHeaders()
                .getFirst(UserContext.CORRELATION_ID)==null) {

            String correlationId = generateCorrelationId();
            ServerHttpRequest request = exchange.getRequest()
                    .mutate()
                    .header(UserContext.CORRELATION_ID, correlationId)
                    .build();

            UserContextHolder.getContext()
                    .setCorrelationId(correlationId);

            logger.info("User correlation id: {}", UserContextHolder.getContext().getCorrelationId());

            ServerWebExchange exchange1 = exchange.mutate()
                    .request(request)
                    .build();

            return chain.filter(exchange1);
        } else {
            ServerHttpRequest request = exchange.getRequest();
            UserContextHolder.getContext()
                    .setCorrelationId(
                            request.getHeaders()
                                    .getFirst(UserContext.CORRELATION_ID));
        }

        logger.info("User correlation id: {}", UserContextHolder.getContext().getCorrelationId());

        return chain.filter(exchange);
    }

    private String generateCorrelationId () {
        return UUID.randomUUID()
                .toString();
    }
}
