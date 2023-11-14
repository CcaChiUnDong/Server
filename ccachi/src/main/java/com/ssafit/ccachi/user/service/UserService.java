package com.ssafit.ccachi.user.service;


import com.ssafit.ccachi.global.dto.converter.DtoConverter;
import com.ssafit.ccachi.global.exception.CustomException;
import com.ssafit.ccachi.user.Entity.User;
import com.ssafit.ccachi.user.dto.request.CreateUserRequestDto;
import com.ssafit.ccachi.user.dto.request.LoginUserRequestDto;
import com.ssafit.ccachi.user.dto.response.EmailCheckResponseDto;
import com.ssafit.ccachi.user.dto.response.UserResponseDto;
import com.ssafit.ccachi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.ssafit.ccachi.global.exception.ErrorCode.WRONG_PASSWORD;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private  final DtoConverter<User, UserResponseDto> converter;
    private final UserRepository userRepository;

    public void createUser(CreateUserRequestDto createUserRequestDto){ userRepository.createUser(createUserRequestDto); }
    public List<UserResponseDto> selectAll(){ return userRepository.selectAll().stream().map(converter::convert).collect(Collectors.toList()); }
    public UserResponseDto select(Long id){ return converter.convert(userRepository.select(id)); }
    public EmailCheckResponseDto check(String email) {  return EmailCheckResponseDto.builder().available(userRepository.check(email)).email(email).build(); }
    public UserResponseDto login(LoginUserRequestDto loginUserRequestDto) throws Exception {
        User user = userRepository.selectByEmail(loginUserRequestDto.getEmail());
        System.out.println(loginUserRequestDto.getEmail());
        System.out.println(loginUserRequestDto.getPassword());
        System.out.println(user);
        if(user.getPassword().equals(loginUserRequestDto.getPassword())){
            return converter.convert(user);
        }else{
            throw new CustomException(WRONG_PASSWORD);
        }

    }

}
