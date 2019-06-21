package com.example.srms.service;

import com.example.srms.domain.dao.SeminarDao;
import com.example.srms.domain.dto.SeminarDTO;
import com.example.srms.domain.entity.Seminar;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeminarService {

    @Autowired
    SeminarDao seminarDao;
    @Autowired
    ModelMapper modelMapper;

    public SeminarDTO findAcceptingSeminar(){
        SeminarDTO seminarDTO = modelMapper.map(seminarDao.selectByAcceptingFlag(), SeminarDTO.class);
        return seminarDTO;
    }

    public List<SeminarDTO> getAllSeminarList(){
        List<SeminarDTO> seminarDTOList = modelMapper.map(seminarDao.selectAllSeminarAndGuestInfo(), new TypeToken<List<SeminarDTO>>() {}.getType());
        return seminarDTOList;
    }

    public SeminarDTO findSeminar(int seminarId){
        SeminarDTO seminarDTO = modelMapper.map(seminarDao.selectBySeminarId(seminarId),SeminarDTO.class);
        return seminarDTO;
    }

}
