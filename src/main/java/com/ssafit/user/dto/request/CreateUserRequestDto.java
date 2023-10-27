package com.ssafit.user.dto.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CreateUserRequestDto {

    @NonNull
    private String userId;
    @NonNull
    private String password;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String phone;

}
