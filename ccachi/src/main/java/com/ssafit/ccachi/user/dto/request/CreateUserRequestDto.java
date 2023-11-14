package com.ssafit.ccachi.user.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CreateUserRequestDto {

    private Long id;
//    @NonNull
    private String password;
//    @NonNull
    private String name;
//    @NonNull
    private String email;
}
