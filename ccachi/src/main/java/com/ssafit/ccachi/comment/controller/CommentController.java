package com.ssafit.ccachi.comment.controller;

import com.ssafit.ccachi.comment.model.dto.request.CreateCommentDto;
import com.ssafit.ccachi.comment.model.dto.response.CommentResponseDto;
import com.ssafit.ccachi.comment.service.CommentService;
import com.ssafit.ccachi.global.dto.response.GeneralStatusResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public GeneralStatusResponse create(@RequestBody CreateCommentDto createCommentDto) throws Exception {
        return commentService.create((createCommentDto));
    }

    @GetMapping("/{board_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentResponseDto> readAll(@PathVariable Long board_id){
        return commentService.readAll(board_id);
    }

    @DeleteMapping("/{comment_id}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralStatusResponse delete(@PathVariable Long comment_id) throws Exception {
        return commentService.delete(comment_id);
    }

    @PatchMapping("")
    @ResponseStatus(HttpStatus.OK)
    public GeneralStatusResponse update(@RequestBody CreateCommentDto createCommentDto) throws Exception {
        return commentService.update(createCommentDto);
    }
}
