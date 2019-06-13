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

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
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
        final int TARGET_INDEX_NUMBER = 0;
        List <SeminarDTO> seminarDTOList = modelMapper.map(seminarDao.selectAllSeminarAndGuestInfo(), new TypeToken<List<SeminarDTO>>() {}.getType());
        List <GuestDTO> guestDTOList = modelMapper.map(guestDao.selectAllGuest(), new TypeToken<List<GuestDTO>>() {}.getType());



//        Supplier<Integer> getNumberOfGuest= () -> {
//            List<SeminarDTO> acceptingSeminar = seminarDTOList.stream()
//                                                              .filter((seminar) -> seminar.getAcceptingFlag()==ACCEPTING_FLAG)
//                                                              .collect(Collectors.toList());
//
//            int numberOfGuest = (int)guestDTOList.stream()
//                                                 .filter((guest) -> guest.getSeminarId()==acceptingSeminar.get(TARGET_INDEX_NUMBER).getSeminarId())
//                                                 .count();
//            return numberOfGuest;
//        };
//
//        Supplier <Integer> getNumberOfHigestGuest= () -> {
//            Map.Entry<Integer, Long> highestSeminar = null;
//            Map<Integer, Long> groupingGuest = guestDTOList.stream().collect(Collectors.groupingBy(GuestDTO::getSeminarId, Collectors.counting()));
//            groupingGuest.forEach((key, value) -> { if(highestSeminar == null || value > highestSeminar.getValue()){
//                                                        highestSeminar.set
//                                                    }
//                                                  });
//
//            return highestGuestList.size();
//        };








        return dashboardDTO;
    }
}
