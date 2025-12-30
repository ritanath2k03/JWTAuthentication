package com.ritanath.jwtauthentication.AppUsers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ritanath.jwtauthentication.AppUsers.model.AppUser;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long>{
    @Query(value = "Select * from users u where u.email=?1",nativeQuery=true)
    AppUser getAppUserByEmail(String email);
    
}
