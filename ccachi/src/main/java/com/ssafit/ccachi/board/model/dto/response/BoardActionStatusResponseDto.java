package com.ssafit.ccachi.board.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BoardActionStatusResponseDto {
    private Boolean status;
}
