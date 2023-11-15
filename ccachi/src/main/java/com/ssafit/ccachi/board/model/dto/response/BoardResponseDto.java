package com.ssafit.ccachi.board.model.dto.response;

import com.ssafit.ccachi.user.model.Entity.User;
import com.ssafit.ccachi.user.model.dto.response.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BoardResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private Long comment_count;
    private UserResponseDto user;
    private LocalDateTime createdAt;
}
