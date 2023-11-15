package com.ssafit.ccachi.board.model.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpdateBoardRequestDto {
    @NonNull
    private Long id;
    @NonNull
    private Long user_id;
    @NonNull
    private String contents;
    @NonNull
    private String title;
}
