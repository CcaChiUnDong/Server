package com.ssafit.ccachi.user.model.dto.response;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserResponseDto {

    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;
}
