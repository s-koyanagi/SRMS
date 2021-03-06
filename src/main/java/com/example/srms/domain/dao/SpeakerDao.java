package com.example.srms.domain.dao;

import com.example.srms.domain.dto.SpeakerDTO;
import com.example.srms.domain.entity.Speaker;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.BatchUpdate;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface SpeakerDao {

    @Select
    List<Speaker> selectBySeminarId(int seminarId);

    @BatchUpdate(sqlFile = true)
    int[] updateBySpeakerId(List<SpeakerDTO> speakerDTOList);

    @BatchInsert
    int[] insert(List<Speaker> speakerList);
}
