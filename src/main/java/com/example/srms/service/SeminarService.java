package com.example.srms.service;

import com.example.srms.domain.dao.SeminarDao;
import com.example.srms.domain.dto.SeminarInfoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeminarService {

    @Autowired
    SeminarDao seminarDao;
    @Autowired
    ModelMapper modelMapper;

    private final static int ACCEPTING_SEMINAR=1;

    public SeminarInfoDto findAcceptingSeminar(){
        SeminarInfoDto seminarInfoDto = modelMapper.map(seminarDao.selectByAcceptingFlag(ACCEPTING_SEMINAR),SeminarInfoDto.class);
        return seminarInfoDto;
    }

}
