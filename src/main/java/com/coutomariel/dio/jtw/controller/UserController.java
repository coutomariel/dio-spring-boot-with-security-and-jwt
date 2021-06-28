package com.coutomariel.dio.jtw.controller;

import com.coutomariel.dio.jtw.data.UserData;
import com.coutomariel.dio.jtw.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserDetailServiceImpl userDetailsService;

    @Autowired
    public UserController(UserDetailServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping("/all-users")
    public List<UserData> listAllUsers(){
        return userDetailsService.listUsers();
    }
}
