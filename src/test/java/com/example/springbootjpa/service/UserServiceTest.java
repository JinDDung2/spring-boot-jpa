package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.UserReqDto;
import com.example.springbootjpa.domain.dto.UserResDto;
import com.example.springbootjpa.domain.entity.User;
import com.example.springbootjpa.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserServiceTest {

    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void 회원가입() throws Exception {
        Mockito.when(userRepository.save(any()))
                .thenReturn(new User(1L, "jinhycuk", "0000"));

        UserResDto userResDto = userService.add(new UserReqDto("jinhyuck", "0000"));

        assertEquals("jinhyuck", userResDto.getUsername());
        assertEquals("회원가입이 완료되었습니다.", userResDto.getMessage());

    }
}