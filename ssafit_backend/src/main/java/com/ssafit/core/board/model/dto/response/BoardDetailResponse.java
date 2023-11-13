package com.ssafit.core.board.model.dto.response;

import java.util.List;

import com.ssafit.core.board.model.entity.Board;
import com.ssafit.core.board.model.entity.BoardType;
import com.ssafit.core.board.model.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDetailResponse {

    private Long boardId;

    private String userId;
    private String subject;
    private String content;

    private Long hit;
    private String currentUpdate;

    private BoardType boardType;
    private List<Comment> comments;

    public static BoardDetailResponse of(
            final Board board,
            final List<Comment> comments) {
        return new BoardDetailResponse(
                board.getBoardId(),
                board.getUserId(),
                board.getSubject(),
                board.getContent(),
                board.getHit(),
                board.getCurrentUpdate(),
                board.getBoardType(),
                comments);
    }
}
