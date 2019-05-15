package com.example.srms.service;

import com.example.srms.domain.dao.EntryDao;
import com.example.srms.domain.dto.GuestInfoDto;
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


    public int newEntry(GuestInfoDto guestInfoDto){
        Guest guest = modelMapper.map(guestInfoDto, Guest.class);
        return entryDao.insert(guest);
    }

}
