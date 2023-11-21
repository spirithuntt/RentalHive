package com.youcode.rentalhive.services;

import com.youcode.rentalhive.application.user.UserServiceImpl;
import com.youcode.rentalhive.domain.user.User;
import com.youcode.rentalhive.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUser() {
        User userToSave = new User(1L, "John Doe", false);

        when(userRepository.save(userToSave)).thenReturn(userToSave);
        User savedUser = userService.save(userToSave);

        assertEquals(userToSave, savedUser);
    }

    @Test
    void findAllUsers() {
        List<User> users = Arrays.asList(
                new User(1L, "John Doe", false),
                new User(2L, "Jane Doe", true)
        );

        when(userRepository.findAll()).thenReturn(users);
        List<User> foundUsers = userService.findAll();

        assertEquals(users, foundUsers);
    }

    @Test
    void findUserById() {
        Long userId = 1L;
        User user = new User(userId, "John Doe", false);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        User foundUser = userService.findById(userId);
        assertEquals(user, foundUser);
    }


}
