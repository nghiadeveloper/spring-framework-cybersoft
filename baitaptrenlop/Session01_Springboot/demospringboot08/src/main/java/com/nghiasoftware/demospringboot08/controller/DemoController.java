package com.nghiasoftware.demospringboot08.controller;

// @Controller: Giúp cho spring boot biết đây là nơi xử lý đường dẫn. Đường dẫn đó phải có giao diện (html,...)
// @RestController: Giúp cho spring boot biết đây là nơi xử lý đường dẫn. Đường dẫn đó phải trả về một chuỗi
// @ResponseBody: Đường dẫn đó chỉ trả ra chuỗi
// @RequestMapping: Định nghĩa đường dẫn

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo")
public class DemoController {

    @GetMapping
    public String demo() {
        return "Hello World";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World BC08";
    }
}
