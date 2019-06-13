package com.example.srms.service;

import com.example.srms.domain.dao.SeminarDao;
import com.example.srms.domain.dto.SeminarDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeminarService {

    @Autowired
    SeminarDao seminarDao;
    @Autowired
    ModelMapper modelMapper;

    public SeminarDTO findAcceptingSeminar(){
        SeminarDTO seminarDto = modelMapper.map(seminarDao.selectByAcceptingFlag(), SeminarDTO.class);
        return seminarDto;
    }

}
