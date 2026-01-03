package com.ritanath.jwtauthentication.AppUsers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


import com.ritanath.jwtauthentication.AppUsers.model.AppUser;
import com.ritanath.jwtauthentication.AppUsers.repository.AppUserRepo;

@Service
public class AppUserService implements UserDetailsService{
    @Autowired
    AppUserRepo userRepo;

    public AppUser insertUser(AppUser user){
        return userRepo.save(user);
    }
    public AppUser getAppUserByEmail(String email){
        return userRepo.getAppUserByEmail(email);
    }
   
    public org.springframework.security.core.userdetails.User loadUserByUsername(String email)
            throws UsernameNotFoundException {

        AppUser user = userRepo.getAppUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList() 
        );
    }
}
