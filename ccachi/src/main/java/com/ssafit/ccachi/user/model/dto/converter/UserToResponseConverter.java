package com.ssafit.ccachi.user.model.dto.converter;

import com.ssafit.ccachi.global.dto.converter.DtoConverter;
import com.ssafit.ccachi.user.model.Entity.User;
import com.ssafit.ccachi.user.model.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserToResponseConverter implements DtoConverter<User, UserResponseDto> {

    @Override
    public UserResponseDto convert(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
