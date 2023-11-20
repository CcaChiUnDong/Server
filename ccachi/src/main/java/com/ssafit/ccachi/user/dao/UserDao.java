package com.ssafit.ccachi.user.dao;

import com.ssafit.ccachi.user.model.Entity.User;
import com.ssafit.ccachi.user.model.dto.request.CreateUserRequestDto;
import com.ssafit.ccachi.user.model.dto.response.UserResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
	List<User> selectAll();
	User select(Long id);
	User selectByEmail(String email);
	void createUser(CreateUserRequestDto createUserRequestDto);
	List<User> checkByEmail(String email);
	void delete(Long id);

	// ID에 해당하는 게시글 하나 가져오기
	UserResponseDto logIn (String email, String password);

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
