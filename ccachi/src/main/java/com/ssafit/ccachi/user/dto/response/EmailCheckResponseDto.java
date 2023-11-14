package com.ssafit.ccachi.user.dto.response;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EmailCheckResponseDto {

    @NonNull
    private boolean available;
    @NonNull
    private String email;
}
