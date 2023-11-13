package com.ssafit.user.dto.converter;

import com.ssafit.global.dto.converter.DtoConverter;
import com.ssafit.user.Entity.User;
import com.ssafit.user.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserToResponseConverter implements DtoConverter<User,UserResponseDto> {

    @Override
    public UserResponseDto convert(User user) {
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .phone(user.getPhone())
                .email(user.getEmail())
                .name(user.getName())
                .grade(user.getGrade())
                .build();
    }
}
