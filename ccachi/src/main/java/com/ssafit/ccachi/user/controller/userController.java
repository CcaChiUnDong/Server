package com.ssafit.ccachi.user.controller;


import com.ssafit.ccachi.user.dto.request.CreateUserRequestDto;
import com.ssafit.ccachi.user.dto.request.EmailCheckRequestDto;
import com.ssafit.ccachi.user.dto.request.LoginUserRequestDto;
import com.ssafit.ccachi.user.dto.response.EmailCheckResponseDto;
import com.ssafit.ccachi.user.dto.response.UserResponseDto;
import com.ssafit.ccachi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class userController {

    private final UserService userService;


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDto> selectAll(){
        return userService.selectAll();
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto select(@PathVariable Long userId){
        return userService.select(userId);
    }
    @PostMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public EmailCheckResponseDto check(@RequestBody EmailCheckRequestDto emailCheckRequestDto){
        System.out.println(emailCheckRequestDto.getEmail());
        return userService.check(emailCheckRequestDto.getEmail());
    }
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public void createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        userService.createUser(createUserRequestDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto login(@RequestBody LoginUserRequestDto loginUserRequestDto) throws Exception {
        return userService.login(loginUserRequestDto);
    }
}