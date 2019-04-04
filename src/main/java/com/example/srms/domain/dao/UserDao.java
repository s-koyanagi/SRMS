package com.example.srms.domain.dao;

import com.example.srms.domain.entity.User;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    public User selectByUserId(String esqId);
}
