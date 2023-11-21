package com.youcode.rentalhive.application.user;

import com.youcode.rentalhive.domain.user.User;
import com.youcode.rentalhive.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User save(User user) ;

    public List<User> findAll() ;

    public User findById(Long id) ;
}
