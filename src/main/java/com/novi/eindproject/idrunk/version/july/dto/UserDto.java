package com.novi.eindproject.idrunk.version.july.dto;

import com.novi.eindproject.idrunk.version.july.model.User;
public class UserDto {
    public String username;
    public String firstname;
    public String lastname;
    public String email;

    public static UserDto fromUser(User user) {
        var dto = new UserDto();
        dto.username = user.getUsername();
        dto.firstname = user.getFirstName();
        dto.lastname = user.getLastName();
        dto.email = user.getEmail();
        return dto;
    }
}
