package com.ssafit.user.dao;

import com.ssafit.user.Entity.User;
import com.ssafit.user.dto.request.LoginUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class UserDao {

    private final EntityManager entityManager;

    public User save(User user){
        entityManager.persist(user);
        return user;
    }
    public User login(LoginUserRequestDto loginUserRequestDto){
        return entityManager.createQuery("select u from User as u where u.userId=:id and u.password=:pwd",User.class)
                .setParameter("id",loginUserRequestDto.getUserId())
                .setParameter("pwd",loginUserRequestDto.getPassword())
                .getResultList().get(0);
    }
}
