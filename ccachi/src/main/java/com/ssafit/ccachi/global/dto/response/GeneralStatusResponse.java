package com.ssafit.ccachi.global.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter @Builder
public class GeneralStatusResponse {
    private Boolean status;
}
