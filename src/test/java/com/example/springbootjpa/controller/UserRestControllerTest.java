package com.example.springbootjpa.controller;

import com.example.springbootjpa.domain.dto.UserReqDto;
import com.example.springbootjpa.domain.dto.UserResDto;
import com.example.springbootjpa.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRestController.class)
class UserRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UserService userService;


    @Test
    @DisplayName("회원가입 중복 테스트")
    void addandDuplicate() throws Exception {
        UserReqDto userReqDto = new UserReqDto("jin", "1234");

        given(userService.add(any(UserReqDto.class))).willReturn(new UserResDto(userReqDto.getUsername(), "해당 username은 중복입니다."));

        mockMvc.perform(post("/api/v1/articles")
                .content(objectMapper.writeValueAsBytes(userReqDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("jin"))
                .andExpect(jsonPath("$.message").value("해당 username은 중복입니다."))
                .andDo(print());

    }

    @Test
    @DisplayName("회원가입 테스트")
    void add() throws Exception {
        UserReqDto userReqDto = new UserReqDto("homidle", "1234");

        given(userService.add(any(UserReqDto.class))).willReturn(new UserResDto(userReqDto.getUsername(), "회원가입이 완료되었습니다."));

        mockMvc.perform(post("/api/v1/articles")
                .content(objectMapper.writeValueAsBytes(userReqDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("homidle"))
                .andExpect(jsonPath("$.message").value("회원가입이 완료되었습니다."))
                .andDo(print());

    }

}