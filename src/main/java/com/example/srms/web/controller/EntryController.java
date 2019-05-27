package com.example.srms.web.controller;

import com.example.srms.domain.dto.GuestInfoDto;
import com.example.srms.domain.dto.SeminarInfoDto;
import com.example.srms.domain.entity.User;
import com.example.srms.service.EntryService;
import com.example.srms.service.SeminarService;
import com.example.srms.service.SpeakerService;
import com.example.srms.web.form.EntryForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping({"/entry"})
public class EntryController {

    @Autowired
    SeminarService seminarService;

    @Autowired
    SpeakerService speakerService;

    @Autowired
    EntryService entryService;

    @Autowired
    ModelMapper modelMapper;


    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv){
        SeminarInfoDto seminarInfoDto = seminarService.findAcceptingSeminar();
        mv.addObject("seminarInfo",seminarService.findAcceptingSeminar());
        mv.addObject("speakerInfo",speakerService.findSpeaker(seminarInfoDto.getSeminarId()));
        mv.addObject("entryForm", new EntryForm());
        mv.setViewName("entry/index");
        return mv;
    }

    @RequestMapping(value="/work", method=RequestMethod.POST)
    public ModelAndView registration(ModelAndView mv, @ModelAttribute EntryForm entryform, @AuthenticationPrincipal User userDetails){
        GuestInfoDto guestInfoDto = modelMapper.map(entryform, GuestInfoDto.class);
        guestInfoDto.setEsqId(userDetails.getEsqId());
        if(entryService.newEntry(guestInfoDto)==0){
            mv.addObject("errorMessage","入力内容は既に申込済です");
            mv.setViewName("entry/index");
            return mv;
        }
        mv.addObject("entryContents", guestInfoDto);
        mv.setViewName("redirect:/mypage");
        return mv;
    }

    @CrossOrigin
    @RequestMapping(value="/ajaxwork", method=RequestMethod.POST)
    public ModelAndView ajaxRegistration(ModelAndView mv, @RequestPart ("jsonValue") EntryForm entryform, @AuthenticationPrincipal User userDetails){
        GuestInfoDto guestInfoDto = modelMapper.map(entryform, GuestInfoDto.class);
        guestInfoDto.setEsqId(userDetails.getEsqId());
        if(entryService.newEntry(guestInfoDto)==0){
            mv.addObject("errorMessage","入力内容は既に申込済です");
            mv.setViewName("entry/index");
            return mv;
        }
        mv.addObject("entryContents", guestInfoDto);
        mv.setViewName("redirect:/mypage");
        return mv;
    }


}
