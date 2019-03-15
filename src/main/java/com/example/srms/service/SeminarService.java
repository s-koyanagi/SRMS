package com.example.srms.service;

import com.example.srms.domain.dao.SeminarDao;
import com.example.srms.domain.model.Seminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeminarService {

    @Autowired
    private SeminarDao seminarDao;

    public Seminar findAcceptingSeminar(){
        return seminarDao.selectByAcceptingFlag(1);
    }
}
