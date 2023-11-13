package com.ssafit.core.board.service;

import com.ssafit.core.board.model.dto.request.CommentModifyRequest;
import com.ssafit.core.board.model.dto.request.CommentSaveRequest;
import com.ssafit.core.board.model.dto.response.CommentResponse;
import com.ssafit.core.board.model.entity.Comment;

import java.util.List;

public interface CommentService {

    Long save(final CommentSaveRequest commentSaveRequest, final String userId, final Long boardId);

    Comment detail(final Long commentId);

    void modify(final Long commentId, final String userId, final CommentModifyRequest request);

    void delete(final Long commentId, final String userId);

    List<CommentResponse> getCommentList(final Long boardId);

    void deleteAll(final Long boardId);
}
