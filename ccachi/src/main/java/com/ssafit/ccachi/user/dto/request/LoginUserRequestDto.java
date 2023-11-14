package com.ssafit.ccachi.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@Builder
public class LoginUserRequestDto {

    @NonNull
    private String email;
    @NonNull
    private String password;


}
