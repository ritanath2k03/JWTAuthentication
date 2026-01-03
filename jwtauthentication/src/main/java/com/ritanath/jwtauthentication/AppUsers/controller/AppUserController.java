package com.ritanath.jwtauthentication.AppUsers.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritanath.jwtauthentication.AppUsers.model.AppUser;
import com.ritanath.jwtauthentication.AppUsers.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class AppUserController {
    @Autowired 
    private AppUserService userService;

    @GetMapping("")
    public AppUser getAppuserByEmail(Authentication authentication){
        String email=authentication.getName();
        
        return userService.getAppUserByEmail(email);
        
    }
}
