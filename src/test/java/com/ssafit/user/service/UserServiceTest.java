package com.ssafit.user.service;

import com.ssafit.user.dto.request.CreateUserRequestDto;
import com.ssafit.user.dto.request.LoginUserRequestDto;
import com.ssafit.user.dto.response.UserResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    void UserCRUD() {
        CreateUserRequestDto newUser = CreateUserRequestDto.builder()
                .userId("테스터99")
                .email("test@test.com")
                .phone("010-010-0101")
                .name("테스터99")
                .password("테스터99")
                .build();
        userService.createUser(newUser);

        UserResponseDto loginUser =
                userService.login(LoginUserRequestDto.builder().userId("테스터99").password("테스터99").build());

        Assertions.assertThat(loginUser.getUserId()).isEqualTo("테스터99");

    }
}