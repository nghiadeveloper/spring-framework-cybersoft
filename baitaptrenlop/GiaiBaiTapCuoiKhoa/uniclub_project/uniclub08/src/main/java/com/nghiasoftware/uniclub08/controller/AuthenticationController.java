package com.nghiasoftware.uniclub08.controller;

import com.nghiasoftware.uniclub08.payload.response.BaseResponse;
import com.nghiasoftware.uniclub08.services.AuthenticationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationServices authenticationServices;

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestParam String email, @RequestParam String password) {
        String token = authenticationServices.authenticate(email, password);

        BaseResponse response = new BaseResponse();
        response.setData(token);

        return ResponseEntity.ok(response);
    }

}
