package com.ssafit.ccachi.board.controller;

import com.ssafit.ccachi.board.model.dto.request.CreateBoardRequestDto;
import com.ssafit.ccachi.board.model.dto.request.SearchConditionRequestDto;
import com.ssafit.ccachi.board.model.dto.request.UpdateBoardRequestDto;
import com.ssafit.ccachi.board.model.dto.response.BoardActionStatusResponseDto;
import com.ssafit.ccachi.board.model.dto.response.BoardResponseDto;
import com.ssafit.ccachi.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@ControllerAdvice(annotations = RestController.class)
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

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public int boardCount() throws Exception {
        return boardService.count();
    }

    @PostMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<BoardResponseDto> search(@RequestBody SearchConditionRequestDto conditionRequestDto) throws Exception {
        System.out.println(conditionRequestDto.toString());
        return boardService.searchWithPaging(conditionRequestDto);
    }

    @GetMapping("/top3")
    @ResponseStatus(HttpStatus.OK)
    public List<BoardResponseDto> readTop3() throws Exception {
        return boardService.readTop3();
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
