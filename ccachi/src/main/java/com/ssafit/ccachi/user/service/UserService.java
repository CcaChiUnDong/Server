package com.ssafit.ccachi.user.service;


import com.ssafit.ccachi.global.dto.converter.DtoConverter;
import com.ssafit.ccachi.user.Entity.User;
import com.ssafit.ccachi.user.dto.request.CreateUserRequestDto;
import com.ssafit.ccachi.user.dto.response.EmailCheckResponseDto;
import com.ssafit.ccachi.user.dto.response.UserResponseDto;
import com.ssafit.ccachi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private  final DtoConverter<User, UserResponseDto> converter;
    private final UserRepository userRepository;

    public void createUser(CreateUserRequestDto createUserRequestDto){ userRepository.createUser(createUserRequestDto); }
    public List<UserResponseDto> selectAll(){ return userRepository.selectAll().stream().map(converter::convert).collect(Collectors.toList()); }
    public UserResponseDto select(Long id){ return converter.convert(userRepository.select(id)); }
    public EmailCheckResponseDto check(String email) {
        System.out.println(email); return EmailCheckResponseDto.builder().available(userRepository.check(email)).email(email).build(); }

}
