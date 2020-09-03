package com.example.demo;

import com.example.demo.aop.DemoBeforeAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AOP_config {
    @Bean
    public Hello hello(){
        return new Hello();
    }

    @Bean
    public DemoBeforeAdvice demoBeforeAdvice(){
        return new DemoBeforeAdvice();
    }
}

