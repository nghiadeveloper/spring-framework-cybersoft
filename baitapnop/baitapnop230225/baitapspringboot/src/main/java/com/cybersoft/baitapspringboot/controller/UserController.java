package com.cybersoft.baitapspringboot.controller;

import com.cybersoft.baitapspringboot.entity.UserEntity;
import com.cybersoft.baitapspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return  userService.getAllUsers();
    }

    @PostMapping
    public void addUser(@RequestBody UserEntity userEntity) {
        UserService userService1 = userService;
        userService1.addUser(userEntity);
    }
}
