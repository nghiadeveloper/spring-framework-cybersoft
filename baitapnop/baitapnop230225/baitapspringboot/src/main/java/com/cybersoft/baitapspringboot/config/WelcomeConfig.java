package com.cybersoft.baitapspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WelcomeConfig {

    @Bean
    public String welcomeMessage() {
        return "Chào mừng bạn đến với Spring Boot";
    }

}
