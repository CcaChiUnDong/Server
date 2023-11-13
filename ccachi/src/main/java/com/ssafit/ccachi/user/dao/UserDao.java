package com.ssafit.ccachi.user.dao;

import com.ssafit.ccachi.user.Entity.User;
import com.ssafit.ccachi.user.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@FunctionalInterface
public interface UserDao {
	List<UserResponseDto> selectAll();

//	// ID에 해당하는 게시글 하나 가져오기
//	public Board selectOne(int id);
//
//	// 게시글 등록
//	public void insertBoard(Board board);
//
//	// 게시글 삭제
//	public void deleteBoard(int id);
//
//	// 게시글 수정
//	public void updateBoard(Board board);
//
//	// 조회수 증가
//	public void updateViewCnt(int id);
//
//	// 검색 기능
//	public List<Board> search(SearchCondition condition);

}
