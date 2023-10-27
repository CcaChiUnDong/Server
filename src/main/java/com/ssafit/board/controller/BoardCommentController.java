package com.ssafit.board.controller;

import com.ssafit.board.model.Board;
import com.ssafit.board.model.BoardComment;
import com.ssafit.board.service.BoardCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BoardCommentController {

    final BoardCommentService boardCommentService;

    public BoardCommentController(BoardCommentService boardCommentService) {
        this.boardCommentService = boardCommentService;
    }


//    // get all comments
//    @GetMapping("/boardComment")
//    public List<BoardComment> getAllComments() {
//        return boardCommentService.getAllComments();
//    }

    @PostMapping("/boardComment")
    public BoardComment createBoardComment(@RequestBody BoardComment boardComment) {
        System.out.println(boardComment);
        return boardCommentService.createBoardComment(boardComment);
    }

    // get board
    @GetMapping("/boardComment/{no}")
    public ResponseEntity<Map> getBoardCommentByBoardNo(
            @PathVariable(value = "no", required = false) Integer boardNo) {
        return boardCommentService.getBoardComments(boardNo);
    }

    @DeleteMapping("/boardComment/{no}")
    public ResponseEntity<Map<String, Boolean>> deleteBoardCommentByNo(
            @PathVariable Integer no) {

        return boardCommentService.deleteBoardComment(no);
    }

}
