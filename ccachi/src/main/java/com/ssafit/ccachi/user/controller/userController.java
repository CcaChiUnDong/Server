package com.ssafit.ccachi.user.controller;


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

//    @PostMapping("/register")
//    @ResponseStatus(HttpStatus.OK)
//    public UserResponseDto signUp(@ModelAttribute CreateUserRequestDto createUserRequestDto){
//        System.out.println(createUserRequestDto.toString());
//        return userService.createUser(createUserRequestDto);
//    }

//    @PostMapping("/login")
//    @ResponseStatus(HttpStatus.OK)
//    public UserResponseDto login(@ModelAttribute LoginUserRequestDto loginUserRequestDto){
//        return userService.login(loginUserRequestDto);
//    }
}