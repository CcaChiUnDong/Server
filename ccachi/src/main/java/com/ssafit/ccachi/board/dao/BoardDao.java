package com.ssafit.ccachi.board.dao;

import com.ssafit.ccachi.board.model.Entity.Board;
import com.ssafit.ccachi.board.model.dto.request.CreateBoardRequestDto;
import com.ssafit.ccachi.board.model.dto.request.UpdateBoardRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    void create(CreateBoardRequestDto createBoardRequestDto);
    List<Board> readAll();
    Board read(Long id);
    void delete(Long id);
    void update(UpdateBoardRequestDto updateBoardRequestDto);
    void visit(Long id);

    List<Board> readTop3();
}
