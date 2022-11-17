package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.dto.UserReqDto;
import com.example.springbootjpa.domain.dto.UserResDto;
import com.example.springbootjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<UserResDto> add(@RequestBody UserReqDto userReqDto) {
        log.info("저장 메서드. name={}", userReqDto);
        UserResDto response = userService.add(userReqDto);
        return ResponseEntity.ok().body(response);
    }
}
