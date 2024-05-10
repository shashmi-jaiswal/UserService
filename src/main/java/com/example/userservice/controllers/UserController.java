package com.example.userservice.controllers;

import com.example.userservice.UserServiceApplication;
import com.example.userservice.dtos.LogInRequestDto;
import com.example.userservice.dtos.LogOutRequestDto;
import com.example.userservice.dtos.SignUpRequestDto;
import com.example.userservice.dtos.UserDto;
import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup") //localhost:8080/users/signup
    public UserDto signUp(@RequestBody SignUpRequestDto requestDto){
        User user = userService.signUp(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );
        //Get userDto from the user.
        // One way is to write a utility function that will conver the user Obj into UserDto
        //Best way is to write a public from(User) in the UserDto class

        return UserDto.from(user);
    }
    @PostMapping("/login") //localhost:8080/users/login
    public Token logIn(@RequestBody LogInRequestDto requestDto){
        //Can also return TokenDto but lets do Token
        return null;

    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logOut(LogOutRequestDto requestDto){
        return null;

    }
}

//Steps
//1. Controller and write the annotations
// - @Controller to define it
// -@ RequestMapping beause we are going to get http request
// 2.  Define the methods with appropritate input and outputs.
//          Create Dtos for those where you will get or return data from client so that you are not
//           exposing the classes drirectly to the client
// 3. Define the implentation in respective Service class so create a service class for the same

// Note Controller will have to get the User object from Service layer and then map it to Dto to
//      send the detail back to the client. SO that User to UserDto mapping should be implemented in
//      the Controller itself
//4. Create an object of User and inject dependency by using a contsrutor.