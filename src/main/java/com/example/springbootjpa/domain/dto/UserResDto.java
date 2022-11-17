package com.example.springbootjpa.domain.dto;

import com.example.springbootjpa.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserResDto {

    private String username;
    private String message;

    public UserResDto(String username) {
        this.username = username;
    }

    public UserResDto(String username, String message) {
        this.username = username;
        this.message = message;
    }

    /*Entity --> response*/
    public static UserResDto from(User user) {
        return new UserResDto(user.getUsername());
    }
}
