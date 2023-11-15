package com.ssafit.ccachi.user.model.dto.request;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailCheckRequestDto {
    @NonNull
    private String email;
}
