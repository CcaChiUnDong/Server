package com.ssafit.ccachi.comment.service;


import com.ssafit.ccachi.comment.model.Entity.Comment;
import com.ssafit.ccachi.comment.model.dto.request.CreateCommentDto;
import com.ssafit.ccachi.comment.model.dto.response.CommentResponseDto;
import com.ssafit.ccachi.comment.model.repository.CommentRepository;
import com.ssafit.ccachi.global.dto.converter.DtoConverter;
import com.ssafit.ccachi.global.dto.response.GeneralStatusResponse;
import com.ssafit.ccachi.user.model.Entity.User;
import com.ssafit.ccachi.user.model.dto.response.UserResponseDto;
import com.ssafit.ccachi.user.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CommentService {

    private final DtoConverter<Comment, CommentResponseDto> converter;
    private final DtoConverter<User, UserResponseDto> userConverter;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public GeneralStatusResponse create(CreateCommentDto createCommentDto) throws Exception {
        commentRepository.create(createCommentDto);
        return GeneralStatusResponse.builder().status(true).build();
    }

    public GeneralStatusResponse update(CreateCommentDto createCommentDto) throws Exception {
        commentRepository.update(createCommentDto);
        return GeneralStatusResponse.builder().status(true).build();
    }

    public GeneralStatusResponse delete(Long comment_id) throws Exception {
        commentRepository.delete(comment_id);
        return GeneralStatusResponse.builder().status(true).build();
    }

    public List<CommentResponseDto> readAll(Long board_id){
        Map<Long, UserResponseDto> userMemo = new HashMap<>();
        List<Comment> commentsList = commentRepository.readAll(board_id);
        List<CommentResponseDto> result = commentsList.stream().map(converter::convert).collect(Collectors.toList());
        for(int i = 0; i < commentsList.size(); i++){
            if(!userMemo.containsKey(commentsList.get(i).getUserId()))
                userMemo.put(
                        commentsList.get(i).getUserId(),
                        userConverter.convert(userRepository.select(commentsList.get(i).getUserId()))
                );
            result.get(i).setUser(userMemo.get(commentsList.get(i).getUserId()));
        }
        return result;
    }
}
