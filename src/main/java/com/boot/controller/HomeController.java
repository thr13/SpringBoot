package com.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home-spring")
    public String hello() {
        System.out.println("HomeController.hello");
        return "hello spring!!";
    }
}
