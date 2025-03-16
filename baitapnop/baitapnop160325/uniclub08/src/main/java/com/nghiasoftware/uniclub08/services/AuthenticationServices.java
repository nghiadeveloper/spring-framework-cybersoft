package com.nghiasoftware.uniclub08.services;

import com.nghiasoftware.uniclub08.entity.User;

public interface AuthenticationServices {

    String authenticate(String username, String password);
    User registerUser(User user);

}
