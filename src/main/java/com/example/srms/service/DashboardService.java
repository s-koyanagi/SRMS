package com.example.srms.service;

import com.example.srms.domain.dao.SeminarDao;
import com.example.srms.domain.dto.DashboardDTO;
import com.example.srms.domain.dto.SeminarDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class DashboardService {

    @Autowired
    SeminarDao seminarDao;
    @Autowired
    ModelMapper modelMapper;

    final int ACCEPTING_FLAG = 1;
    final int TARGET_INDEX_NUMBER = 0;

    public DashboardDTO getAnalyticsData(){
        DashboardDTO dashboardDTO = new DashboardDTO();

        List <SeminarDTO> seminarDTOList = modelMapper.map(seminarDao.selectAllSeminarAndGuestInfo(), new TypeToken<List<SeminarDTO>>() {}.getType());

        Supplier<Integer> getAcceptingNumberOfGuest = () -> {
            SeminarDTO acceptingSeminar = seminarDTOList.stream()
                                                        .filter((seminar) -> seminar.getAcceptingFlag() == ACCEPTING_FLAG)
                                                        .collect(Collectors.collectingAndThen(toList(), list -> list.get(TARGET_INDEX_NUMBER)));
            return acceptingSeminar.getNumberOfGuest();
        };

        Supplier <Integer> getNumberOfHighestGuest = () -> {
            Optional<SeminarDTO> numberOfHighestGuestSeminar = seminarDTOList.stream()
                                                                            .max((seminar1, seminar2) -> ((Integer)seminar1.getNumberOfGuest()).compareTo(seminar2.getNumberOfGuest()));
            return numberOfHighestGuestSeminar.get().getNumberOfGuest();
        };

        dashboardDTO.setNumberOfGuest(getAcceptingNumberOfGuest.get());
        dashboardDTO.setNumberOfHighestGuest(getNumberOfHighestGuest.get());

        return dashboardDTO;
    }
}
