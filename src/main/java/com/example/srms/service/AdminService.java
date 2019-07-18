package com.example.srms.service;

import com.example.srms.domain.dao.GuestDao;
import com.example.srms.domain.dao.SeminarDao;
import com.example.srms.domain.dao.SpeakerDao;
import com.example.srms.domain.dto.GuestDTO;
import com.example.srms.domain.dto.SeminarDTO;
import com.example.srms.domain.dto.SpeakerDTO;
import com.example.srms.domain.entity.ImmutableSeminar;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    SeminarDao seminarDao;
    @Autowired
    GuestDao guestDao;
    @Autowired
    SpeakerDao speakerDao;
    @Autowired
    ModelMapper modelMapper;

    public SeminarDTO getSeminarInfo(int seminarId){
        SeminarDTO seminarDTO = modelMapper.map(seminarDao.selectBySeminarId(seminarId),SeminarDTO.class);
        return seminarDTO;
    }

    public List<GuestDTO> getGuestList(int seminarId){
        List<GuestDTO> guestDTOList = modelMapper.map(guestDao.selectGuestListBySeminarId(seminarId), new TypeToken<List<GuestDTO>>() {}.getType());
        return guestDTOList;
    }

    public boolean registerEditInfo (SeminarDTO seminarDTO, List<SpeakerDTO> speakerDTOList){
        seminarDTO.setEventDate(seminarDTO.getEventDate().replaceAll("日","").replaceAll("\\p{InCjkUnifiedIdeographs}","-"));
        seminarDTO.setStartedDateTime(seminarDTO.getEventDate()+" "+seminarDTO.getStartedTime()+":00");
        seminarDTO.setClosedDateTime(seminarDTO.getEventDate()+" "+seminarDTO.getClosedTime()+":00");

        seminarDao.updateBySeminarId(seminarDTO);
        speakerDao.updateBySpeakerId(speakerDTOList);
        return true;
    }

    public boolean registerCreateInfo(SeminarDTO seminarDTO, List<SpeakerDTO> speakerDTOList){
        Date date = new Date();
        seminarDTO.setEventDate(seminarDTO.getEventDate().replaceAll("日","").replaceAll("\\p{InCjkUnifiedIdeographs}","-"));
        ImmutableSeminar seminar = new ImmutableSeminar(null,seminarDTO.getTitle(),"test",seminarDTO.getEventDate()+" "+seminarDTO.getStartedTime()+":00",
                seminarDTO.getEventDate()+" "+seminarDTO.getClosedTime()+":00", date,null,null,1,1);
        ImmutableSeminar result = seminarDao.insert(seminar).getEntity();
        return true;
    }
}
