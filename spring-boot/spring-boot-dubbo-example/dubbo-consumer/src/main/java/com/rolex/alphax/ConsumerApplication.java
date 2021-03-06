/*
 * Copyright (C) 2020 bsyonline
 */
package com.rolex.alphax;

import com.rolex.alphax.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rolex
 * @since 2020
 */
@SpringBootApplication
@Slf4j
@RestController
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Reference(version = "1.0.0")
    private DemoService demoService;

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return demoService.sayHello(name);
    }

}
