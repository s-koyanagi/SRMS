package com.example.srms.service;

import com.example.srms.domain.dao.EntryDao;
import com.example.srms.domain.dto.ApplicantInfoDto;
import com.example.srms.domain.entity.Guest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    @Autowired
    EntryDao entryDao;

    @Autowired
    ModelMapper modelMapper;


    public int newEntry(ApplicantInfoDto applicantInfoDto){
        Guest guest = new Guest();
        guest = modelMapper.map(applicantInfoDto, guest.getClass());
        return entryDao.insert(guest);
    }

}
