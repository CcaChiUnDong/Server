package com.ssafit.ccachi.comment.dao;

import com.ssafit.ccachi.comment.model.Entity.Comment;
import com.ssafit.ccachi.comment.model.dto.request.CreateCommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {
    void create(CreateCommentDto createCommentDto);
    List<Comment> readAll(Long board_id);
    void delete(Long comment_id);
    void update(CreateCommentDto createCommentDto);
}
