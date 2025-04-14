package com.cybersoft.uniclub08.controller;

import com.cybersoft.uniclub08.payload.request.SignupRequest;
import com.cybersoft.uniclub08.payload.response.BaseResponse;
import com.cybersoft.uniclub08.services.AuthenticationServices;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

/**
 * {
 *     "code": 200,
 *     "message": "",
 *     "data":
 * }
 *
 */

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

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignupRequest request) {
        BaseResponse response = new BaseResponse();
        response.setData(request);

        return ResponseEntity.ok(response);
    }

}
