package com.ssafit.core.user.controller;

import com.ssafit.core.user.model.dto.request.UserAddRequest;
import com.ssafit.core.user.model.dto.request.UserLoginRequest;
import com.ssafit.core.user.model.dto.request.UserModifyRequest;
import com.ssafit.core.user.model.dto.response.UserResponse;
import com.ssafit.core.user.service.UserService;
import com.ssafit.global.auth.model.dto.LoginUser;
import com.ssafit.global.auth.model.dto.NoAuth;
import com.ssafit.global.auth.model.dto.request.LogoutRequest;
import com.ssafit.global.auth.model.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @NoAuth
    @PostMapping
    public ResponseEntity<Boolean> join(@RequestBody final UserAddRequest requestUser) {
        return ResponseEntity.ok(userService.join(requestUser));
    }

    @NoAuth
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TokenResponse> login(@RequestBody final UserLoginRequest request) {
        System.out.println("login~~~");
        return ResponseEntity.ok(userService.login(request));
    }

    @GetMapping("/info/{userId}")
    public ResponseEntity<UserResponse> getInfo(@PathVariable final String userId) {
        return ResponseEntity.ok(userService.getInformation(userId));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(
            @LoginUser final String loginUser, @RequestBody final LogoutRequest request) {
        userService.logout(loginUser, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> modify(
            @RequestBody final UserModifyRequest request, @LoginUser final String userId) {
        userService.modify(request, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(
            @PathVariable final String userId, @LoginUser final String loginUser) {
        userService.delete(userId, loginUser);
        return ResponseEntity.noContent().build();
    }
}
