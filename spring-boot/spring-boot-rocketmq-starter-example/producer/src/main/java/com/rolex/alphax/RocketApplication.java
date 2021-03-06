/*
 * Copyright (C) 2020 bsyonline
 */
package com.rolex.alphax;

import com.rolex.alphax.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rolex
 * @since 2020
 */
@RestController
@SpringBootApplication
public class RocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketApplication.class, args);
    }

    @Autowired
    Producer producer;

    @GetMapping("/test")
    public void test(){
        producer.send();
    }
}
