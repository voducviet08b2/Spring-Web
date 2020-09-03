package com.codegym.democreatespringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Bean
    public Logger logger() {
        return new Logger();
    }
}
