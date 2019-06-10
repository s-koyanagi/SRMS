package com.example.srms.service;

import com.example.srms.domain.dao.GuestDao;
import com.example.srms.domain.dto.GuestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

    @Autowired
    GuestDao guestDao;


    public int newEntry(GuestDTO guestDto){
        return guestDao.insert(guestDto);
    }

    public boolean isAlreadyEntry(GuestDTO guestDto){
        if(guestDao.selectById(guestDto)==null){
            return false;
        }
        return true;
    }

    public int cancelEntry(GuestDTO guestDto){
        return guestDao.updateById(guestDto);
    }

}
