package com.ssafit.ccachi.board.controller;

import com.ssafit.ccachi.board.model.dto.request.CreateBoardRequestDto;
import com.ssafit.ccachi.board.model.dto.request.UpdateBoardRequestDto;
import com.ssafit.ccachi.board.model.dto.response.BoardActionStatusResponseDto;
import com.ssafit.ccachi.board.model.dto.response.BoardResponseDto;
import com.ssafit.ccachi.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public BoardActionStatusResponseDto create(@RequestBody CreateBoardRequestDto createBoardRequestDto) throws Exception {
        return boardService.create(createBoardRequestDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<BoardResponseDto> readAll() throws Exception {
        return boardService.readAll();
    }
    @GetMapping("/{boardId}")
    @ResponseStatus(HttpStatus.OK)
    public BoardResponseDto read(@PathVariable Long boardId) throws Exception {
        return boardService.read(boardId);
    }

    @DeleteMapping("/{boardId}")
    @ResponseStatus(HttpStatus.OK)
    public BoardActionStatusResponseDto delete(@PathVariable Long boardId) throws Exception {
        return boardService.delete(boardId);
    }

    @PatchMapping("/{boardId}")
    @ResponseStatus(HttpStatus.OK)
    public BoardActionStatusResponseDto update(@RequestBody UpdateBoardRequestDto updateBoardRequestDto) throws Exception {
        return boardService.update(updateBoardRequestDto);
    }
}
