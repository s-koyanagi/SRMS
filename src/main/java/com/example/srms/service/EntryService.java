package com.example.srms.service;

import com.example.srms.domain.dao.GuestDao;
import com.example.srms.domain.dto.GuestDTO;
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


    public int newEntry(GuestDTO guestDto){
        Guest guest = modelMapper.map(guestDto, Guest.class);
        return guestDao.insert(guest);
    }

    public boolean isAlreadyEntry(GuestDTO guestDto){
        Guest guest = modelMapper.map(guestDto,Guest.class);
        if(guestDao.selectById(guest)==null){
            return false;
        }
        return true;
    }

    public int cancelEntry(GuestDTO guestDto){
        Guest guest = modelMapper.map(guestDto,Guest.class);
        return guestDao.updateById(guest);
    }

}
