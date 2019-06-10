package com.example.srms.service;

import com.example.srms.domain.dao.SpeakerDao;
import com.example.srms.domain.dto.SpeakerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeakerService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    SpeakerDao speakerDao;

    public SpeakerDTO[] findSpeaker(int seminarId){
        SpeakerDTO[] speakers = modelMapper.map(speakerDao.selectBySeminarId(seminarId), SpeakerDTO[].class);
        return speakers;
    }
}
