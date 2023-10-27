package com.ssafit.user.controller;

import com.ssafit.user.dto.request.CreateUserRequestDto;
import com.ssafit.user.dto.request.LoginUserRequestDto;
import com.ssafit.user.dto.response.UserResponseDto;
import com.ssafit.user.service.UserService;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@ApiModel(value = "유저 정보")
public class userController {

    private final UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto signUp(@ModelAttribute CreateUserRequestDto createUserRequestDto){
        return userService.createUser(createUserRequestDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto login(@ModelAttribute LoginUserRequestDto loginUserRequestDto){
        return userService.login(loginUserRequestDto);
    }
}