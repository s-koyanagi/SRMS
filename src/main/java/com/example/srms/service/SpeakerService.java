package com.example.srms.service;

import com.example.srms.domain.dao.SpeakerDao;
import com.example.srms.domain.dto.SpeakerInfoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    SpeakerDao speakerDao;

    public SpeakerInfoDto[] findSpeaker(int seminarId){
        SpeakerInfoDto[] speakers = modelMapper.map(speakerDao.selectBySeminarId(seminarId),SpeakerInfoDto[].class);
        return speakers;
    }
}