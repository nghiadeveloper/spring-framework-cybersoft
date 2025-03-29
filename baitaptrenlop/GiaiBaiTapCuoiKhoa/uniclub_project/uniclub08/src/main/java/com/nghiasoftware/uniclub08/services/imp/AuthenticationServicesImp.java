package com.nghiasoftware.uniclub08.services.imp;

import com.nghiasoftware.uniclub08.entity.User;
import com.nghiasoftware.uniclub08.repository.UserRepository;
import com.nghiasoftware.uniclub08.services.AuthenticationServices;
import com.nghiasoftware.uniclub08.utils.JwtHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServicesImp implements AuthenticationServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public String authenticate(String username, String password) {
        String token = "";
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                token = jwtHelper.generateToken("Hello");
            }
        }
        return token;
    }

}
