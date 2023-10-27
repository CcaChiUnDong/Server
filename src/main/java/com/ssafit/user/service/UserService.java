package com.ssafit.user.service;

import com.ssafit.global.dto.converter.DtoConverter;
import com.ssafit.user.Entity.User;
import com.ssafit.user.dto.request.CreateUserRequestDto;
import com.ssafit.user.dto.request.LoginUserRequestDto;
import com.ssafit.user.dto.response.UserResponseDto;
import com.ssafit.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private  final DtoConverter<User,UserResponseDto> converter;
    private final UserRepository userRepository;

    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto){
        User newUser = User.builder()
                .email(createUserRequestDto.getEmail())
                .userId(createUserRequestDto.getUserId())
                .phone(createUserRequestDto.getPhone())
                .password(createUserRequestDto.getPassword())
                .name(createUserRequestDto.getName())
                .build();
        System.out.println(11);
        userRepository.save(newUser);
        System.out.println(22);
        return converter.convert(newUser);
    }

    public UserResponseDto login(LoginUserRequestDto loginUserRequestDto){
        return converter.convert(userRepository.login(loginUserRequestDto));
    }
}
