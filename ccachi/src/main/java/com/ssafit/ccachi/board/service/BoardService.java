package com.ssafit.ccachi.board.service;

import com.ssafit.ccachi.board.model.Entity.Board;
import com.ssafit.ccachi.board.model.dto.request.CreateBoardRequestDto;
import com.ssafit.ccachi.board.model.dto.response.BoardResponseDto;
import com.ssafit.ccachi.board.model.dto.response.CreateBoardResponseDto;
import com.ssafit.ccachi.board.model.repository.BoardReposiroty;
import com.ssafit.ccachi.global.dto.converter.DtoConverter;
import com.ssafit.ccachi.user.model.Entity.User;
import com.ssafit.ccachi.user.model.dto.response.UserResponseDto;
import com.ssafit.ccachi.user.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final DtoConverter<Board,BoardResponseDto> converter;
    private final DtoConverter<User,UserResponseDto> userConverter;
    private final BoardReposiroty boardReposiroty;
    private final UserRepository userRepository;

    public CreateBoardResponseDto createBoard(CreateBoardRequestDto createBoardRequestDto) throws Exception {
        boardReposiroty.createBoard(createBoardRequestDto);
        return CreateBoardResponseDto.builder().created(true).build();
    }

    public List<BoardResponseDto> readAll(){
        List<Board> boardList = boardReposiroty.readAll();
        Map<Long, UserResponseDto> userMap = new HashMap<>();
        for(Board board : boardList){
            if(!userMap.containsKey(board.getUserId())){
                System.out.println(board.getUserId());
                userMap.put(board.getUserId(),userConverter.convert(userRepository.select(board.getUserId())));
            }
        }
        List<BoardResponseDto> result = boardList.stream().map(converter::convert).collect(Collectors.toList());
        for(BoardResponseDto board : result){
            board.setUser(userMap.get(board.getUserId()));
        }
        return result;
    }

    public BoardResponseDto read(Long id){
        Board targetBoard = boardReposiroty.read(id);
        BoardResponseDto result = converter.convert(targetBoard);
        UserResponseDto user = userConverter.convert(userRepository.select(result.getUserId()));
        result.setUser(user);
        return result;
    }

}
