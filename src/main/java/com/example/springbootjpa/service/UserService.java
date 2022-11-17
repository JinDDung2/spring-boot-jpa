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

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserResDto add(@RequestBody UserReqDto userReqDto) {
        log.info("회원가입 실행. username={}", userReqDto.getUsername());
        List<User> all = userRepository.findAll();
        for (User user : all) {
            if(user.getUsername().equals(userReqDto.getUsername())) {
                return new UserResDto(userReqDto.getUsername(), "해당 username은 중복입니다.");
            }
        }
        User user = userReqDto.toEntity();
        userRepository.save(user);
        UserResDto response = UserResDto.from(user);
        response.setMessage("회원가입이 완료되었습니다.");
        return response;
    }
}
