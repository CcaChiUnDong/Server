package com.ssafit.ccachi.user.controller;


import com.ssafit.ccachi.global.dto.response.GeneralStatusResponse;
import com.ssafit.ccachi.global.token.JwtTokenUtils;
import com.ssafit.ccachi.user.model.dto.request.CreateUserRequestDto;
import com.ssafit.ccachi.user.model.dto.request.EmailCheckRequestDto;
import com.ssafit.ccachi.user.model.dto.request.LoginUserRequestDto;
import com.ssafit.ccachi.user.model.dto.response.EmailCheckResponseDto;
import com.ssafit.ccachi.user.model.dto.response.UserResponseDto;
import com.ssafit.ccachi.user.service.UserService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173/", exposedHeaders = "Authorization")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class userController {

    private final UserService userService;

    @Value("${jwt.secretKey}")
    private String key;
    @Value("${jwt.expireLength}")
    private Long expiredTimeMs;

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
        return userService.check(emailCheckRequestDto.getEmail());
    }
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public void createUser(@RequestBody CreateUserRequestDto createUserRequestDto){
        userService.createUser(createUserRequestDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserResponseDto> login(@RequestBody LoginUserRequestDto loginUserRequestDto) throws Exception {
        UserResponseDto result = userService.login(loginUserRequestDto);
        String token = JwtTokenUtils.generateToken(result,key,expiredTimeMs);
        return ResponseEntity.ok().header("Authorization", "Bearer " + token).body(result);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserResponseDto> tokenLogin(@RequestHeader Map<String, String> data) throws Exception{
        String token = data.get("authorization").substring(7);
        Claims claims = JwtTokenUtils.parseJwtToken(token,key);
        UserResponseDto result = userService.select(new Long(String.valueOf(claims.get("id"))));
        System.out.println(ResponseEntity.ok().body(result));
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> delete(@RequestHeader Map<String, String> data) throws Exception{
        String token = data.get("authorization").substring(7);
        return ResponseEntity.ok().body(userService.delete(new Long(String.valueOf(JwtTokenUtils.parseJwtToken(token,key).get("id")))));
    }
}