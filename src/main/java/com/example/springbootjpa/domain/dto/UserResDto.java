package com.example.springbootjpa.domain.dto;

import com.example.springbootjpa.domain.entity.User;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class UserResDto {

    private Long id;
    private String username;
    private String message;

    @Builder
    public UserResDto(Long id, String username, String message) {
        this.id = id;
        this.username = username;
        this.message = message;
    }

    public UserResDto(String username, String message) {
        this.username = username;
        this.message = message;
    }

    /*Entity --> response*/
    public static UserResDto from(User user) {
        return new UserResDto(user.getUsername(), user.getUsername());
    }
}
