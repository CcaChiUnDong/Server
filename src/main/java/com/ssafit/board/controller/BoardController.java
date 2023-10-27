package com.ssafit.board.controller;
import java.util.List;
import java.util.Map;

import com.ssafit.board.model.Board;
import com.ssafit.board.service.BoardService;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ApiModel(value = "게시판 정보")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // get paging board # 페이징 처리를 할 수 있도록 수정
    @GetMapping("/board")
    public ResponseEntity<Map> getAllBoards(@RequestParam(value = "p_num", required=false) Integer p_num) {
        if (p_num == null || p_num <= 0) p_num = 1;

        return boardService.getPagingBoard(p_num);
    }
//    // get all board
//    @GetMapping("/board")
//    public List<Board> getAllBoards() {
//        return boardService.getAllBoard();
//    }

    // create board
    @PostMapping("/board")
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    // get board
    @GetMapping("/board/{no}")
    public ResponseEntity<Board> getBoardByNo(
            @PathVariable Integer no) {

        return boardService.getBoard(no);
    }

    // update board
    @PutMapping("/board/{no}")
    public ResponseEntity<Board> updateBoardByNo(
            @PathVariable Integer no, @RequestBody Board board){

        return boardService.updateBoard(no, board);
    }

    // delete board
    @DeleteMapping("/board/{no}")
    public ResponseEntity<Map<String, Boolean>> deleteBoardByNo(
            @PathVariable Integer no) {

        return boardService.deleteBoard(no);
    }
}