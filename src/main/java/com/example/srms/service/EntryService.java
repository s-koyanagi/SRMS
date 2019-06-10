package com.example.srms.service;

import com.example.srms.domain.dao.GuestDao;
import com.example.srms.domain.dto.GuestInfoDto;
import com.example.srms.domain.entity.Guest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    @Autowired
    GuestDao guestDao;

    @Autowired
    ModelMapper modelMapper;


    public int newEntry(GuestInfoDto guestInfoDto){
        Guest guest = modelMapper.map(guestInfoDto, Guest.class);
        return guestDao.insert(guest);
    }

    public boolean isAlreadyEntry(GuestInfoDto guestInfoDto){
        Guest guest = modelMapper.map(guestInfoDto,Guest.class);
        if(guestDao.selectById(guest)==null){
            return false;
        }
        return true;
    }

    public int cancelEntry(GuestInfoDto guestInfoDto){
        Guest guest = modelMapper.map(guestInfoDto,Guest.class);
        return guestDao.updateById(guest);
    }

}
