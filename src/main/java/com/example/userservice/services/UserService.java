package com.example.userservice.services;

import com.example.userservice.UserServiceApplication;
import com.example.userservice.dtos.SignUpRequestDto;
import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    //https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security/3.2.5

    UserService(UserRepository userRepository,
                BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User signUp(String name, String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent()){
            //If user already in database, no need to signup, just return the user
            return optionalUser.get();
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setHashedPassword(bCryptPasswordEncoder.encode(password));

        User savedUser = userRepository.save(user);

        //SET THE PASSWORD AS A HASHED PASSWORD. CONTINUE FROM HERE
        return savedUser;

    }

    public Token logIn(String email , String password){
        return null;
    }

    public void logOut(Token token){
        return;
    }
}
