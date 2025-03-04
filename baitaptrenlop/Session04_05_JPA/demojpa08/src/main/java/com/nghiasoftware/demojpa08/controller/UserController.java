package com.nghiasoftware.demojpa08.controller;

import com.nghiasoftware.demojpa08.dto.RoleDTO;
import com.nghiasoftware.demojpa08.dto.UserDTO;
import com.nghiasoftware.demojpa08.entity.Users;
import com.nghiasoftware.demojpa08.entity.UsersRoles;
import com.nghiasoftware.demojpa08.repository.UsersRepository;
import com.nghiasoftware.demojpa08.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(userServiceImp.getAllUsers());
    }

}
