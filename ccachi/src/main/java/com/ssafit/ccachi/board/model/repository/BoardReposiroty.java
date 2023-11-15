package com.ssafit.ccachi.board.model.repository;

import com.ssafit.ccachi.board.dao.BoardDao;
import com.ssafit.ccachi.board.model.Entity.Board;
import com.ssafit.ccachi.board.model.dto.request.CreateBoardRequestDto;
import com.ssafit.ccachi.board.model.dto.request.UpdateBoardRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class BoardReposiroty {

    private final BoardDao boardDao;

    public void create(CreateBoardRequestDto createBoardRequestDto) throws Exception{ boardDao.create(createBoardRequestDto);}

    public List<Board> readAll(){ return boardDao.readAll(); }
    public Board read(Long id){ return boardDao.read(id); }
    public void delete(Long id){ boardDao.delete(id); }
    public void update(UpdateBoardRequestDto updateBoardRequestDto) throws Exception{ boardDao.update(updateBoardRequestDto);}
}
