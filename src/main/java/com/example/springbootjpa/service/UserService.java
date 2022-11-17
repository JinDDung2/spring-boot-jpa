package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.UserReqDto;
import com.example.springbootjpa.domain.dto.UserResDto;
import com.example.springbootjpa.domain.entity.User;
import com.example.springbootjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserResDto add(@RequestBody UserReqDto userReqDto) {
        User user = userReqDto.toEntity();
        User savedUser = userRepository.save(user);
        UserResDto response = UserResDto.from(savedUser);
        return response;
    }
}
