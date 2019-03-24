package com.example.srms.domain.dao;

import com.example.srms.domain.entity.Applicant;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface EntryDao {

    @Insert(sqlFile = true)
    int insert(Applicant applicant);
}
