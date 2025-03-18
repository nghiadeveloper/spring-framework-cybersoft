package com.nghiasoftware.baitapuniclub08.controller;

import com.nghiasoftware.baitapuniclub08.entity.User;
import com.nghiasoftware.baitapuniclub08.payload.response.BaseResponse;
import com.nghiasoftware.baitapuniclub08.services.UserService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/user/sign-up")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public BaseResponse<List<User>> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public BaseResponse<User> getUserById(@Valid @PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public BaseResponse<User> createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/{id}")
    public BaseResponse<User> updateUser(@Valid @PathVariable int id, @Valid @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteUser(@Valid @PathVariable int id) {
        return userService.deleteUserById(id);
    }

}
