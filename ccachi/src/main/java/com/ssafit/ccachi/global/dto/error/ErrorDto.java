package com.ssafit.ccachi.global.dto.error;

import lombok.*;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    @NonNull
    private int status;
    String message;
}

