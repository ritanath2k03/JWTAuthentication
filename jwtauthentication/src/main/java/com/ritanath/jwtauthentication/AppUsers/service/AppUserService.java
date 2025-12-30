package com.ritanath.jwtauthentication.AppUsers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritanath.jwtauthentication.AppUsers.model.AppUser;
import com.ritanath.jwtauthentication.AppUsers.repository.AppUserRepo;

@Service
public class AppUserService {
    @Autowired
    AppUserRepo userRepo;

    public AppUser insertUser(AppUser user){
        return userRepo.save(user);
    }
    public AppUser getAppUserByEmail(String email){
        return userRepo.getAppUserByEmail(email);
    }
}
