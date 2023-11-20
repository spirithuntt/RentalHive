package com.youcode.rentalhive;

import com.youcode.rentalhive.domain.user.User;
import com.youcode.rentalhive.domain.user.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RentalHiveApplication {


    public static void main(String[] args) {
        SpringApplication.run(RentalHiveApplication.class, args);
    }



}

