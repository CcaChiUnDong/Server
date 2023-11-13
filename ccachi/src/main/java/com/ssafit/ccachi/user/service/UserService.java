package com.ssafit.ccachi.user.service;


import com.ssafit.ccachi.global.dto.converter.DtoConverter;
import com.ssafit.ccachi.user.Entity.User;
import com.ssafit.ccachi.user.dto.response.UserResponseDto;
import com.ssafit.ccachi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private  final DtoConverter<User, UserResponseDto> converter;
    private final UserRepository userRepository;

//    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto){
//
//    }
    public List<UserResponseDto> selectAll(){
        return userRepository.selectAll();
    }

//    public UserResponseDto login(LoginUserRequestDto loginUserRequestDto){
//        return converter.convert(userRepository.login(loginUserRequestDto));
//    }
}
