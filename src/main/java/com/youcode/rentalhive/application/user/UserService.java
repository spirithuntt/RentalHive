package com.youcode.rentalhive.application.user;


import com.youcode.rentalhive.domain.user.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User save(User user) ;
}
