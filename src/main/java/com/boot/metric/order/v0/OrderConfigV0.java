package com.boot.metric.order.v0;

import com.boot.metric.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV0 {

    @Bean
    OrderService orderService() {
        return new OrderServiceV0();
    }
}
