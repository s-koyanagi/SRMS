package com.example.srms.web.controller;

import com.example.srms.domain.dto.GuestInfoDto;
import com.example.srms.domain.dto.SeminarInfoDto;
import com.example.srms.domain.entity.User;
import com.example.srms.service.EntryService;
import com.example.srms.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    SeminarService seminarService;

    @Autowired
    EntryService entryService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv, @AuthenticationPrincipal User userDetails) {
        GuestInfoDto guestInfoDto = new GuestInfoDto();
        guestInfoDto.setSeminarId(seminarService.findAcceptingSeminar().getSeminarId());
        guestInfoDto.setEsqId(userDetails.getEsqId());
        mv.addObject("isAlreadyEntry",entryService.isAlreadyEntry(guestInfoDto));
        mv.setViewName("mypage/index");
        return mv;
    }

}