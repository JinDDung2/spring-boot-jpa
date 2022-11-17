package com.example.springbootjpa.domain.dto;

import com.example.springbootjpa.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserReqDto {

    private Long id;
    private String username;
    private String password;

    public UserReqDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /* request --> entity*/
    public User toEntity() {
        return new User(id, username, password);
    }
}
