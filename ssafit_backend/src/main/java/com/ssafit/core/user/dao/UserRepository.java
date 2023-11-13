package com.ssafit.core.user.dao;

import java.util.Optional;

import com.ssafit.core.user.model.entity.User;
import com.ssafit.core.user.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserRepository {

    private final UserMapper userMapper;

    public Optional<User> selectByUserId(final String userId) {
        return userMapper.selectByUserId(userId);
    }

    @Transactional
    public int updateByUser(final User user) {
        return userMapper.updateByUser(user);
    }

    @Transactional
    public int insertByUser(final User user) {
        return userMapper.insertByUser(user);
    }

    @Transactional
    public void deleteByUserId(final String userId) {
        userMapper.deleteByUserId(userId);
    }
}
