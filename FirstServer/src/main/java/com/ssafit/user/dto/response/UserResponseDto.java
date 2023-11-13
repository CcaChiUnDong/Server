package com.ssafit.user.dto.response;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserResponseDto {

    @NonNull
    private String userId;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String phone;
    @NonNull
    private String grade;

}
