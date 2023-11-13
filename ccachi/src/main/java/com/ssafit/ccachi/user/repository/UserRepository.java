package com.ssafit.ccachi.user.repository;

import com.ssafit.ccachi.user.dao.UserDao;
import com.ssafit.ccachi.user.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepository {

    private final UserDao userDao;

    public List<UserResponseDto> selectAll(){
        List<UserResponseDto> result = userDao.selectAll();
        System.out.println(result);
        return result;
    }
//    public User login(LoginUserRequestDto loginUserRequestDto){ return userDao.login(loginUserRequestDto);}
}
