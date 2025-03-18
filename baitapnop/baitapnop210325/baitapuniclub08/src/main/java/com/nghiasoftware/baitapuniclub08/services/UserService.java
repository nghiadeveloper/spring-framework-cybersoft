package com.nghiasoftware.baitapuniclub08.services;

import com.nghiasoftware.baitapuniclub08.entity.User;
import com.nghiasoftware.baitapuniclub08.payload.response.BaseResponse;

import java.util.List;

public interface UserService {
    public BaseResponse<List<User>> getAllUsers();
    public BaseResponse<User> getUserById(int id);
    public BaseResponse<User> createUser(User user);
    public BaseResponse<User> updateUser(int id, User user);
    public BaseResponse<Void> deleteUserById(int id);
}
