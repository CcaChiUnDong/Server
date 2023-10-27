package com.ssafit.user.repository;

import com.ssafit.user.Entity.User;
import com.ssafit.user.dao.UserDao;
import com.ssafit.user.dto.request.LoginUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
@RequiredArgsConstructor
public class UserRepository {


    private final UserDao userDao;
    public User save(User user){
        return userDao.save(user);
    }

    public User login(LoginUserRequestDto loginUserRequestDto){ return userDao.login(loginUserRequestDto);}
}
