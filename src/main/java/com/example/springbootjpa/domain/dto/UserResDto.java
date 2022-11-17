package com.example.springbootjpa.domain.dto;

import com.example.springbootjpa.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResDto {

    private Long id;
    private String username;

    public UserResDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    /*Entity --> response*/
    public static UserResDto from(User user) {
        return new UserResDto(user.getId(), user.getUsername());
    }
}
