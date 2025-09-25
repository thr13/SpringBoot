package com.boot.metric.controller;

import com.boot.metric.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public String order() {
        log.info("주문");
        orderService.order();
        return "order";
    }

    @GetMapping("/cancel")
    public String cancel() {
        log.info("취소");
        orderService.cancel();
        return "cancel";
    }

    @GetMapping("/stock")
    public int stock() {
        log.info("재고");
        return orderService.getStock().get();
    }
}
