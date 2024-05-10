package com.example.userservice.dtos;

import com.example.userservice.models.Role;
import com.example.userservice.models.User;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String email;
    private String name;
    //we want to return the email and name, not the password back to the user\
    //We return roles and isEmailVerified
    @ManyToMany
    private List<Role> roles;
    private boolean isEmailVerified;

    public static UserDto from(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        userDto.setEmailVerified(user.isEmailVerified());
        return userDto;

    }


}
