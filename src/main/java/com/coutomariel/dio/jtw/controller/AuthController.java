package com.coutomariel.dio.jtw.controller;

import com.coutomariel.dio.jtw.data.UserData;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/login")
    public void login(@RequestBody UserData user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    }

}
