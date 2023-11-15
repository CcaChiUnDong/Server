package com.ssafit.ccachi.board.controller;

import com.ssafit.ccachi.board.model.dto.request.CreateBoardRequestDto;
import com.ssafit.ccachi.board.model.dto.response.BoardResponseDto;
import com.ssafit.ccachi.board.model.dto.response.CreateBoardResponseDto;
import com.ssafit.ccachi.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
    public CreateBoardResponseDto create(@RequestBody CreateBoardRequestDto createBoardRequestDto) throws Exception {
        return boardService.createBoard(createBoardRequestDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<BoardResponseDto> readAll() throws Exception {
        return boardService.readAll();
    }
}
