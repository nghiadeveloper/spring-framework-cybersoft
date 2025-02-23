package com.cybersoft.baitapspringboot.service;

import com.cybersoft.baitapspringboot.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<UserEntity> users = new ArrayList<>();

    // Lấy danh sách người dùng
    public List<UserEntity> getAllUsers() {
        return users;
    }

    // Thêm người dùng mới
    public void addUser(UserEntity userEntity) {
        users.add(userEntity);
    }
}
