package com.ssafit.core.user.model.mapper;

import java.util.Optional;

import com.ssafit.core.user.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    Optional<User> selectByUserId(final String userId);

    int updateByUser(final User user);

    int insertByUser(final User user);

    void deleteByUserId(final String userId);
}
