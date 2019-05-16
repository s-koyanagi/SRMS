package com.example.srms.domain.dao;

import com.example.srms.domain.entity.Guest;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface EntryDao {

    @Insert(sqlFile = true)
    int insert(Guest guest);

    @Select
    Guest selectById(Guest guest);
}
