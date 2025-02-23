package com.cybersoft.baitapspringboot.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String helloService() {
        return "Chào mừng đến với ứng dụng Spring Boot!";
    }
}
