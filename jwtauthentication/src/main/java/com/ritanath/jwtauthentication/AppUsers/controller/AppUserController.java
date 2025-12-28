package com.ritanath.jwtauthentication.AppUsers.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritanath.jwtauthentication.AppUsers.model.AppUser;
import com.ritanath.jwtauthentication.AppUsers.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class AppUserController {
    @Autowired 
    private AppUserService userService;

    @PostMapping("")
    public AppUser postMethodName(@RequestBody AppUser entity) {
        if(entity.getName()==null||entity.getPassword()==null)return null;
        return userService.insertUser(entity);
    }
    
}
