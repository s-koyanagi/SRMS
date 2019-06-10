package com.example.srms.domain.dao;

import com.example.srms.domain.dto.GuestDTO;
import com.example.srms.domain.entity.Guest;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface GuestDao {

    @Insert(sqlFile = true)
    int insert(GuestDTO guest);

    @Select
    Guest selectById(GuestDTO guest);

    @Update(sqlFile = true)
    int updateById(GuestDTO guest);
}
