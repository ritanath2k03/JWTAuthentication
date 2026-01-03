package com.ritanath.jwtauthentication.AppUsers.controller;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritanath.jwtauthentication.AppUsers.model.AppUser;
import com.ritanath.jwtauthentication.AppUsers.service.AppUserService;
import com.ritanath.jwtauthentication.utils.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

     @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired(required=true)
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired 
    private AppUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUser request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()));
        if (authentication.isAuthenticated()) {
            String token = jwtUtil.generateToken(request.getEmail());
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("tokenType", "Bearer");
            response.put("email", request.getEmail());
            response.put("issuedAt", Instant.now().toString());

            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body("Authentication failed password incorrect.");

    }
     @PostMapping("/signup")
    public AppUser createAppUser(@RequestBody AppUser entity) {
        String encodedPassword =
                passwordEncoder.encode(entity.getPassword());
        if(entity.getName()==null||entity.getPassword()==null)return null;
        entity.setPassword(encodedPassword);
        return userService.insertUser(entity);
    }
}
