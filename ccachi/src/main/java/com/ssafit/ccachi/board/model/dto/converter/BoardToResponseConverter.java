package com.ssafit.ccachi.board.model.dto.converter;

import com.ssafit.ccachi.board.model.Entity.Board;
import com.ssafit.ccachi.board.model.dto.response.BoardResponseDto;
import com.ssafit.ccachi.global.dto.converter.DtoConverter;
import org.springframework.stereotype.Component;

@Component
public class BoardToResponseConverter implements DtoConverter<Board, BoardResponseDto> {

    @Override
    public BoardResponseDto convert(Board obj) {
        return BoardResponseDto.builder()
                .id(obj.getId())
                .comment_count(obj.getCommentCount())
                .contents(obj.getContents())
                .createdAt(obj.getCreatedAt())
                .title(obj.getTitle())
                .userId(obj.getUserId())
                .visited(obj.getVisited())
                .build();
    }

}
