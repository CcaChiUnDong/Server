package com.ssafit.ccachi.user.repository;

import com.ssafit.ccachi.global.exception.CustomException;
import com.ssafit.ccachi.user.Entity.User;
import com.ssafit.ccachi.user.dao.UserDao;
import com.ssafit.ccachi.user.dto.request.CreateUserRequestDto;
import com.ssafit.ccachi.user.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ssafit.ccachi.global.exception.ErrorCode.WRONG_EMAIL;
import static com.ssafit.ccachi.global.exception.ErrorCode.WRONG_USER_ID;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepository {

    private final UserDao userDao;

    public List<User> selectAll(){
        List<User> result = userDao.selectAll();
        return result;
    }
    public User select(long id){
        User result = userDao.select(id);
        if(result == null) throw new CustomException(WRONG_USER_ID);
        return result;
    }
    public User selectByEmail(String email){
        User result = userDao.selectByEmail(email);
        if(result == null) throw new CustomException(WRONG_EMAIL);
        return result;
    }
    public void createUser(CreateUserRequestDto createUserRequestDto){
        userDao.createUser(createUserRequestDto);
    }
    public boolean check(String email){
        List<User> userList = userDao.checkByEmail(email);
        return userList.isEmpty();
    }
//    public User login(LoginUserRequestDto loginUserRequestDto){ return userDao.login(loginUserRequestDto);}
}
