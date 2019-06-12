package com.example.srms.service;

import com.example.srms.domain.dao.GuestDao;
import com.example.srms.domain.dao.SeminarDao;
import com.example.srms.domain.dto.DashboardDTO;
import com.example.srms.domain.dto.GuestDTO;
import com.example.srms.domain.dto.SeminarDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    SeminarDao seminarDao;
    @Autowired
    GuestDao guestDao;
    @Autowired
    ModelMapper modelMapper;

    public DashboardDTO getAnalyticsData(){
        DashboardDTO dashboardDTO = new DashboardDTO();
        final int ACCEPTING_FLAG = 1;
        List <SeminarDTO> seminarDTOList = modelMapper.map(seminarDao.selectAllSeminar(), new TypeToken<List<SeminarDTO>>() {}.getType());
        List<GuestDTO> guestDTOList = modelMapper.map(guestDao.selectAllGuest(), new TypeToken<List<GuestDTO>>() {}.getType());

        Function <List<GuestDTO>, Integer> getNumberOfGuest= (i) -> {
            List<SeminarDTO> acceptingSeminar = seminarDTOList.stream()
                                                              .filter((seminar) -> seminar.getAcceptingFlag()==ACCEPTING_FLAG)
                                                              .collect(Collectors.toList());

            int numberOfGuest = (int)guestDTOList.stream()
                                                 .filter((guest) -> guest.getSeminarId()==acceptingSeminar.get(0).getAcceptingFlag())
                                                 .count();
            return numberOfGuest;
        };

        Function <List<GuestDTO>, Integer> getNumberOfHigestGuest= (i) -> {
            List<GuestDTO> highestGuestList = new ArrayList<>();

            return highestGuestList.size();
        };




        dashboardDTO.setNumberOfGuest(getNumberOfGuest.apply(guestDTOList));
        dashboardDTO.setNumberOfTotalGuest(guestDTOList.size());
        //dashboardDTO.setNumberOfHighestGuest();




        return dashboardDTO;
    }
}
