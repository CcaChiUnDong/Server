package com.ssafit.ccachi.comment.model.dto.response;


import com.ssafit.ccachi.user.model.dto.response.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter @Setter @Builder
public class CommentResponseDto {
    private Long id;
    private String content;
    private UserResponseDto user;
    private Long board_id;
    private LocalDateTime create_at;
}
