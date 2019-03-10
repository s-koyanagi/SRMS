package com.example.srms.domain.repository;

import com.example.srms.domain.model.UserInfoEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    public UserInfoEntity selectByUserId(String userId);
}
