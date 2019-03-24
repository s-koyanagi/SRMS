package com.example.srms.service;

import com.example.srms.domain.dao.EntryDao;
import com.example.srms.domain.dto.ApplicantInfoDto;
import com.example.srms.domain.entity.Applicant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EntryService {

    @Autowired
    EntryDao entryDao;

    @Autowired
    ModelMapper modelMapper;


    public int newEntry(ApplicantInfoDto applicantInfoDto){
        Applicant applicant = new Applicant();
        applicant = modelMapper.map(applicantInfoDto,applicant.getClass());
        return entryDao.insert(applicant);
    }

}
