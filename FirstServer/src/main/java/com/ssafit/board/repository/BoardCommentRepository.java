package com.ssafit.board.repository;

import com.ssafit.board.model.Board;
import com.ssafit.board.model.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Integer> {
    public final static String SELECT_BOARD_COMMENT_LIST_PAGED = ""
            + "SELECT "
//            + "no, user_id, comment, created_time "
            + "*"
            + " FROM board_comment"
            + " WHERE board_no = ?1 "
            + " ORDER BY created_time DESC";

    @Query(value = SELECT_BOARD_COMMENT_LIST_PAGED, nativeQuery = true)
    List<BoardComment> findByBoardNo(final Integer boardNo);
}
