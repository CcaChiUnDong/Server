package com.ssafit.core.board.model.mapper;

import com.github.pagehelper.Page;
import java.util.Optional;

import com.ssafit.core.board.model.dto.request.BoardSearchRequest;
import com.ssafit.core.board.model.entity.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    Long insertBoard(final Board board);

    Optional<Board> selectBoard(final Long boardId);

    Page<Board> selectAll();

    Page<Board> selectBoardListBySearchDto(final BoardSearchRequest boardSearchRequest);

    void updateBoard(final Board board);

    void updateHit(final Long boardId);

    void deleteBoard(final Long boardId);
}
