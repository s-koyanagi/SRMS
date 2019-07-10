package com.example.srms.domain.dao;

import com.example.srms.domain.dto.SeminarDTO;
import com.example.srms.domain.entity.Seminar;
import com.example.srms.domain.entity.SeminarGuest;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface SeminarDao {

    @Select
    Seminar selectByAcceptingFlag();

    @Select
    List<SeminarGuest> selectAllSeminarAndGuestInfo();

    @Select
    Seminar selectBySeminarId(int seminarId);

    @Update
    int updateBySeminarId(SeminarDTO seminar);

}
