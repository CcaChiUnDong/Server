package com.ssafit.ccachi.user.dto.request;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailCheckRequestDto {
    @NonNull
    private String email;
}
