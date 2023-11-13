package com.ssafit.ccachi.global.config.user;

import com.ssafit.ccachi.global.dto.converter.DtoConverter;
import com.ssafit.ccachi.user.Entity.User;
import com.ssafit.ccachi.user.dto.converter.UserToResponseConverter;
import com.ssafit.ccachi.user.dto.response.UserResponseDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class userConfig {
//    @Bean
    public DtoConverter<User, UserResponseDto> UserToResponseConverter() {
        return new UserToResponseConverter();
    }
}
