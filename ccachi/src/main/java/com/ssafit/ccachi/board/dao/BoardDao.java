package com.ssafit.ccachi.board.dao;

import com.ssafit.ccachi.board.model.Entity.Board;
import com.ssafit.ccachi.board.model.dto.request.CreateBoardRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface BoardDao {
    void create(CreateBoardRequestDto createBoardRequestDto);
    List<Board> readAll();
}
