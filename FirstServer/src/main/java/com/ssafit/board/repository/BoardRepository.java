package com.ssafit.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafit.board.model.Board;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaRepository클래스를 상속받는다
//JpaRepository의 파라미터 인자에 <Board클래스와 , Integer를 설정>
public interface BoardRepository extends JpaRepository<Board, Integer> {
    public final static String SELECT_BOARD_LIST_PAGED = ""
            + "SELECT "
            + "no,"
            + "type,"
            + "title,"
            + "contents,"
            + "member_no,"
            + "created_time,"
            + "updated_time,"
            + "likes,"
            + "counts"
            + " FROM board WHERE 0 < no "
            + "ORDER BY no DESC LIMIT ?1, ?2";

    @Query(value = SELECT_BOARD_LIST_PAGED, nativeQuery = true)
    List<Board> findFromTo(
            final Integer objectStartNum,
            final Integer objectEndNum);
}