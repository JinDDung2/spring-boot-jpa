package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.dto.UserReqDto;
import com.example.springbootjpa.domain.dto.UserResDto;
import com.example.springbootjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResDto> findById(@PathVariable Long id) {
        log.info("restController findById. id={}", id);
        UserResDto response = userService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("")
    public ResponseEntity<UserResDto> add(@RequestBody UserReqDto userReqDto) {
        log.info("restController add. name={}", userReqDto.getUsername());
        UserResDto response = userService.add(userReqDto);
        return ResponseEntity.ok().body(response);
    }
}
