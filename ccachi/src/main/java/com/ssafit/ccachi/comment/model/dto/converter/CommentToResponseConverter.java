package com.ssafit.ccachi.comment.model.dto.converter;

import com.ssafit.ccachi.comment.model.Entity.Comment;
import com.ssafit.ccachi.comment.model.dto.response.CommentResponseDto;
import com.ssafit.ccachi.global.dto.converter.DtoConverter;
import org.springframework.stereotype.Component;

@Component
public class CommentToResponseConverter implements DtoConverter<Comment, CommentResponseDto> {

    @Override
    public CommentResponseDto convert(Comment comment){
        CommentResponseDto result = CommentResponseDto.builder()
                .board_id(comment.getBoardId())
                .id(comment.getId())
                .content(comment.getContent())
                .create_at(comment.getCreatedAt())
                .build();
        return result;
    }
}
