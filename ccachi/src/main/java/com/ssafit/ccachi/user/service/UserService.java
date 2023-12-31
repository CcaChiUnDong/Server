package com.ssafit.ccachi.user.service;


import com.ssafit.ccachi.global.dto.converter.DtoConverter;
import com.ssafit.ccachi.global.dto.response.GeneralStatusResponse;
import com.ssafit.ccachi.global.exception.CustomException;
import com.ssafit.ccachi.global.token.JwtTokenUtils;
import com.ssafit.ccachi.user.model.Entity.User;
import com.ssafit.ccachi.user.model.dto.request.CreateUserRequestDto;
import com.ssafit.ccachi.user.model.dto.request.LoginUserRequestDto;
import com.ssafit.ccachi.user.model.dto.response.EmailCheckResponseDto;
import com.ssafit.ccachi.user.model.dto.response.UserResponseDto;
import com.ssafit.ccachi.user.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.ssafit.ccachi.global.exception.ErrorCode.WRONG_PASSWORD;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final DtoConverter<User, UserResponseDto> converter;
    private final UserRepository userRepository;



    public void createUser(CreateUserRequestDto createUserRequestDto){ userRepository.createUser(createUserRequestDto); }
    public List<UserResponseDto> selectAll(){ return userRepository.selectAll().stream().map(converter::convert).collect(Collectors.toList()); }
    public UserResponseDto select(Long id){ return converter.convert(userRepository.select(id)); }
    public GeneralStatusResponse delete(Long id){
        userRepository.delete(id);
        return GeneralStatusResponse.builder().status(true).build();
    }
    public EmailCheckResponseDto check(String email) {  return EmailCheckResponseDto.builder().available(userRepository.check(email)).email(email).build(); }
    public UserResponseDto login(LoginUserRequestDto loginUserRequestDto) throws Exception {
        User user = userRepository.selectByEmail(loginUserRequestDto.getEmail());
        if(user.getPassword().equals(loginUserRequestDto.getPassword())){
            return converter.convert(user);
        }else{
            throw new CustomException(WRONG_PASSWORD);
        }

    }

}
