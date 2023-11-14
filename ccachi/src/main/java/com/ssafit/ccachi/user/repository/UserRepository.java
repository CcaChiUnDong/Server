package com.ssafit.ccachi.user.repository;

import com.ssafit.ccachi.user.Entity.User;
import com.ssafit.ccachi.user.dao.UserDao;
import com.ssafit.ccachi.user.dto.request.CreateUserRequestDto;
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

    public List<User> selectAll(){
        List<User> result = userDao.selectAll();
        System.out.println(result);
        return result;
    }
    public User select(long id){
        User result = userDao.select(id);
        System.out.println(result);
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
