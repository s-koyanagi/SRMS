package com.example.srms.domain.dao;

import com.example.srms.domain.dto.GuestDTO;
import com.example.srms.domain.entity.Guest;
import com.example.srms.domain.entity.GuestUser;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface GuestDao {

    @Insert(sqlFile = true)
    int insert(GuestDTO guest);

    @Select
    Guest selectById(GuestDTO guest);

    @Update(sqlFile = true)
    int updateById(GuestDTO guest);

    @Select
    List<Guest> selectAllGuest();

    @Select
    List<GuestUser> selectGuestListBySeminarId(int seminarId);
}
