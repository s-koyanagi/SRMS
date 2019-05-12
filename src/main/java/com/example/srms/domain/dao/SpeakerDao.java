package com.example.srms.domain.dao;

import com.example.srms.domain.entity.Speaker;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface SpeakerDao {

    @Select
    Speaker selectBySeminarId(int seminarId);
}
