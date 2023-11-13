package com.ssafit.core.board.controller;

import java.net.URI;
import java.util.List;

import com.ssafit.core.board.model.dto.request.CommentModifyRequest;
import com.ssafit.core.board.model.dto.request.CommentSaveRequest;
import com.ssafit.core.board.model.dto.response.CommentResponse;
import com.ssafit.core.board.service.CommentService;
//import com.ssafit.global.auth.model.dto.LoginUser;
//import com.ssafit.global.auth.model.dto.NoAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@CrossOrigin(origins = "*")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{boardId}")
    public ResponseEntity<Long> registerComment(
            @PathVariable final Long boardId,
            @RequestBody final CommentSaveRequest commentSaveRequest,
//            @LoginUser final String userId) {
            final String userId) {
        final Long commentId = commentService.save(commentSaveRequest, userId, boardId);

        return ResponseEntity.created(URI.create("/comment/" + commentId)).body(commentId);
    }

//    @NoAuth
    @GetMapping("/{boardId}")
    public ResponseEntity<List<CommentResponse>> getCommentList(@PathVariable final Long boardId) {
        return ResponseEntity.ok(commentService.getCommentList(boardId));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Void> modifyComment(
            @PathVariable final Long commentId,
//            @LoginUser final String userId,
            final String userId,
            @RequestBody final CommentModifyRequest request) {
        commentService.modify(commentId, userId, request);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
//            @LoginUser final String userId, @PathVariable final Long commentId) {
            final String userId, @PathVariable final Long commentId) {
        commentService.delete(commentId, userId);

        return ResponseEntity.noContent().build();
    }
}
