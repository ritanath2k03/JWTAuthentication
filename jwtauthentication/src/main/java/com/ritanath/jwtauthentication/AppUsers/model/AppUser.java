package com.ritanath.jwtauthentication.AppUsers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "users")

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long uId;
    String name;
    String password;
    @Column
    String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getuId() {
        return uId;
    }
    public void setuId(Long uId) {
        this.uId = uId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
   
}
