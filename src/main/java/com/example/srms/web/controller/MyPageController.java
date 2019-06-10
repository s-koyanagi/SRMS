package com.example.srms.web.controller;

import com.example.srms.domain.dto.GuestDTO;
import com.example.srms.domain.dto.SeminarDTO;
import com.example.srms.domain.entity.User;
import com.example.srms.service.EntryService;
import com.example.srms.service.SeminarService;
import com.example.srms.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @Autowired
    SeminarService seminarService;

    @Autowired
    EntryService entryService;

    @Autowired
    SpeakerService speakerService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv, @AuthenticationPrincipal User userDetails) {
        GuestDTO guestDto = new GuestDTO();
        guestDto.setSeminarId(seminarService.findAcceptingSeminar().getSeminarId());
        guestDto.setEsqId(userDetails.getEsqId());
        mv.addObject("isAlreadyEntry",entryService.isAlreadyEntry(guestDto));
        mv.setViewName("mypage/index");
        return mv;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value={"/getseminar"}, method=RequestMethod.GET)
    public Map<String, Object> testJson(@AuthenticationPrincipal User userDetails){
        Map<String, Object> entryInfo = new HashMap<String, Object>();
        SeminarDTO acceptingSeminar = seminarService.findAcceptingSeminar();

        GuestDTO guestDto = new GuestDTO();
        guestDto.setSeminarId(acceptingSeminar.getSeminarId());
        guestDto.setEsqId(userDetails.getEsqId());

        entryInfo.put("seminar", acceptingSeminar);
        entryInfo.put("speakers",speakerService.findSpeaker(acceptingSeminar.getSeminarId()));
        entryInfo.put("isEntered",entryService.isAlreadyEntry(guestDto));
        return entryInfo;
    }
}