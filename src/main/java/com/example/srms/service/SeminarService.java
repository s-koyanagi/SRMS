package com.example.srms.service;

import com.example.srms.domain.dao.SeminarDao;
import com.example.srms.domain.dto.SeminarDTO;
import com.example.srms.domain.entity.Seminar;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        //List<SeminarDTO> seminarDTOList = modelMapper.map(seminarDao.selectAllSeminarAndGuestInfo(), new TypeToken<List<SeminarDTO>>() {}.getType());
        List<SeminarDTO> seminarDTOList = seminarDao.selectAllSeminarAndGuestInfo().stream().map(x -> modelMapper.map(x, SeminarDTO.class)).collect(Collectors.toList());
        return seminarDTOList.stream().sorted(Comparator.comparingInt(SeminarDTO::getSeminarId).reversed()).collect(Collectors.toList());
    }

}
