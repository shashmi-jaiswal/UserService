package com.example.userservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Configurations {
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();

    }

}
//This class will create a bean of all those that have a @Bean annotations
// during the start of the application.
//Whatever beans yuo are creating it will store it in the spring application context file.
/*
* Here Bcrypt class cannot be presented by an annotation like @COntroller
* or anything like
* But for the Service class to inject that dependency we need a class already created in
* the start of the application
* So, we use @Bean annotation in the COnfiguarations class to  manually create that Object at the start of the app
*  */


