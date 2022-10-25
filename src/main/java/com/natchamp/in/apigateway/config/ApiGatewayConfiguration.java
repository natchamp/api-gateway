package com.natchamp.in.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder)
    {
        return builder
                .routes()
                .route(p -> p.path("/get").filters(f -> f.addRequestHeader("x-raceId", "12345")).uri("http://httpbin.org:80"))
                .route(p->p.path("/book/**").uri("lb://BOOK-STORE-SERVICES-DEV"))
                .route(p->p.path("/payment/**").uri("lb://PAYMENT-SERVICE")).build();
    }
}
