package com.example.srms.service;

import com.example.srms.domain.dao.SpeakerDao;
import com.example.srms.domain.dto.SpeakerInfoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeakerService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    SpeakerDao speakerDao;

    public SpeakerInfoDto findSpeaker(int seminarId){
        SpeakerInfoDto speakerInfoDto = new SpeakerInfoDto();
        speakerInfoDto = modelMapper.map(speakerDao.selectBySeminarId(seminarId),speakerInfoDto.getClass());
        return speakerInfoDto;
    }
}
