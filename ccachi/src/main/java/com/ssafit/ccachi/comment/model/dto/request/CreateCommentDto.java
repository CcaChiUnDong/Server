package com.ssafit.ccachi.comment.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter @Builder
public class CreateCommentDto {
    private Long id;
    private Long board_id;
    private Long user_id;
    private String content;

}
