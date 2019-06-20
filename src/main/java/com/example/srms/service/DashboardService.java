package com.example.srms.service;

import com.example.srms.domain.dao.SeminarDao;
import com.example.srms.domain.dto.DashboardDTO;
import com.example.srms.domain.dto.SeminarDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    SeminarDao seminarDao;
    @Autowired
    ModelMapper modelMapper;

    final int ACCEPTING_FLAG = 1;

    public DashboardDTO getAnalyticsData(){
        DashboardDTO dashboardDTO = new DashboardDTO();
        List <SeminarDTO> seminarDTOList = modelMapper.map(seminarDao.selectAllSeminarAndGuestInfo(), new TypeToken<List<SeminarDTO>>() {}.getType());

        SeminarDTO maximumGuestSeminar  = seminarDTOList.stream()
                .max((seminar1, seminar2) -> ((Integer)seminar1.getNumberOfGuest()).compareTo(seminar2.getNumberOfGuest())).get();
        SeminarDTO acceptingSeminar = seminarDTOList.stream()
                .filter((seminar) -> seminar.getAcceptingFlag() == ACCEPTING_FLAG).findFirst().get();

        dashboardDTO.setNumberOfTotalGuest(seminarDTOList.stream().mapToInt(seminar -> seminar.getNumberOfGuest()).sum());
        dashboardDTO.setNumberOfGuest(acceptingSeminar.getNumberOfGuest());
        dashboardDTO.setTitleOfAcceptingSeminar(acceptingSeminar.getTitle());
        dashboardDTO.setNumberOfMaximumGuest(maximumGuestSeminar.getNumberOfGuest());
        dashboardDTO.setTitleOfMaximumGuest(maximumGuestSeminar.getTitle());
        dashboardDTO.setNumberOfAverageGuest(seminarDTOList.stream().mapToInt(seminar -> seminar.getNumberOfGuest()).average().getAsDouble());
        dashboardDTO.setNumberOfSeminar(seminarDTOList.size());

        return dashboardDTO;
    }
}
