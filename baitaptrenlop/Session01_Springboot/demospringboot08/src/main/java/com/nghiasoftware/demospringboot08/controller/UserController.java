package com.nghiasoftware.demospringboot08.controller;

import com.nghiasoftware.demospringboot08.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    // Lấy đối tượng đã lưu trữ trên IOC xuống và sử dụng
    @Autowired
    private NhanVien nhanVien;

    @GetMapping
    public String getUser() {
        return "Hello User: " + nhanVien.getUsername();
    }

    @GetMapping("/add")
    public String addUser() {
        return "Hello Add User";
    }

    @GetMapping("/update")
    public String updateUser() {
        return "Hello Update User";
    }
}
