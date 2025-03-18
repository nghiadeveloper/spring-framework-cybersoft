package com.nghiasoftware.baitapuniclub08.services.imp;

import com.nghiasoftware.baitapuniclub08.entity.User;
import com.nghiasoftware.baitapuniclub08.exception.NotFoundException;
import com.nghiasoftware.baitapuniclub08.payload.response.AcceptedResponse;
import com.nghiasoftware.baitapuniclub08.payload.response.BaseResponse;
import com.nghiasoftware.baitapuniclub08.payload.response.OkResponse;
import com.nghiasoftware.baitapuniclub08.repository.UserRepository;
import com.nghiasoftware.baitapuniclub08.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BaseResponse<List<User>> getAllUsers() {
        return new OkResponse<>(userRepository.findAll());
    }

    @Override
    public BaseResponse<User> getUserById(int id) {
        return userRepository.findById(id)
                .map(OkResponse::new)
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase()));
    }

    @Override
    public BaseResponse<User> createUser(User user) {
        return new OkResponse<>(userRepository.save(user));
    }

    @Override
    public BaseResponse<User> updateUser(int id, User user) {
        return userRepository.findById(id)
                .map(foundUser -> {
                    foundUser.setUsername(user.getUsername());
                    foundUser.setPassword(user.getPassword());
                    foundUser.setFullname(user.getFullname());
                    foundUser.setPhone(user.getPhone());
                    foundUser.setRole(user.getRole());
                    return new OkResponse(userRepository.save(foundUser));
                })
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase()));
    }

    @Override
    public BaseResponse<Void> deleteUserById(int id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new AcceptedResponse<>();
        }
        throw new NotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase());
    }

}
