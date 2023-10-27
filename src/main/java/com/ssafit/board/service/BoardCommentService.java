package com.ssafit.board.service;

import com.ssafit.board.exception.ResourceNotFoundException;
import com.ssafit.board.model.Board;
import com.ssafit.board.model.BoardComment;
import com.ssafit.board.repository.BoardRepository;
import com.ssafit.board.repository.BoardCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardCommentService {
    private final BoardCommentRepository boardCommentRepository;

//    public List<BoardComment> getAllComments() {
//        return boardCommentRepository.findAll();
//    }
    public ResponseEntity<Map> getBoardComments(Integer boardNo) {
        Map result = new HashMap<>();

        List<BoardComment> list = boardCommentRepository.findByBoardNo(boardNo);

        if (list == null || list.size() == 0) {
            return null;
        }

        result.put("list", list);

        return ResponseEntity.ok(result);
    }

    //create board Comment
    public BoardComment createBoardComment(BoardComment boardComment) {
        return boardCommentRepository.save(boardComment);
    }


    // delete board Comment
    public ResponseEntity<Map<String, Boolean>> deleteBoardComment(Integer no) {
        BoardComment boardComment = boardCommentRepository.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+no+"]"));

        boardCommentRepository.delete(boardComment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted BoardComment Data by id : ["+no+"]", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
