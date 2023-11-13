package com.ssafit.core.board.service;

import com.ssafit.core.board.model.dto.request.BoardModifyRequest;
import com.ssafit.core.board.model.dto.request.BoardSaveRequest;
import com.ssafit.core.board.model.dto.request.BoardSearchRequest;
import com.ssafit.core.board.model.dto.response.BoardDetailResponse;
import com.ssafit.global.dto.PageResponse;

public interface BoardService {

    Long saveBoard(final BoardSaveRequest request, final String userId);

    BoardDetailResponse detail(final Long boardId);

    PageResponse getBoardList(final BoardSearchRequest boardSearchRequest);

    void modify(final Long boardId, final String userId, final BoardModifyRequest boardModifyRequest);

    void updateHit(final Long boardId);

    void delete(final Long boardId, final String userId);
}
