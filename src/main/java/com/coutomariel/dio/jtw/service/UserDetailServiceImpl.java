package com.coutomariel.dio.jtw.service;

import com.coutomariel.dio.jtw.data.UserData;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class UserDetailServiceImpl implements UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserData user = findByUser(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }

        return new User(user.getUserName(), user.getPassword(), Collections.emptyList());
    }

    private UserData findByUser(String username) {

        UserData user = new UserData();
        user.setUserName("admin");
        user.setPassword(bCryptPasswordEncoder.encode("senha"));
        return user;
    }

    public List<UserData> listUsers(){
        ArrayList<UserData> users = new ArrayList<>();
        users.add(findByUser("Admin"));
        return users;
    }
}
