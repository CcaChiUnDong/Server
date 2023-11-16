package com.ssafit.ccachi.comment.model.repository;

import com.ssafit.ccachi.comment.dao.CommentDao;
import com.ssafit.ccachi.comment.model.Entity.Comment;
import com.ssafit.ccachi.comment.model.dto.request.CreateCommentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class CommentRepository {

    private final CommentDao commentDao;

    public void create(CreateCommentDto createCommentDto) throws Exception{
        commentDao.create(createCommentDto);
    }
    public List<Comment> readAll(Long board_id){return commentDao.readAll(board_id);}
}
