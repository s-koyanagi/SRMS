package com.example.srms.web.controller;

import com.example.srms.domain.dto.GuestDTO;
import com.example.srms.domain.dto.SeminarDTO;
import com.example.srms.domain.entity.User;
import com.example.srms.service.EntryService;
import com.example.srms.service.SeminarService;
import com.example.srms.service.SpeakerService;
import com.example.srms.web.form.EntryForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        SeminarDTO seminarDto = seminarService.findAcceptingSeminar();
        mv.addObject("seminarInfo",seminarService.findAcceptingSeminar());
        mv.addObject("speakerInfo",speakerService.findSpeaker(seminarDto.getSeminarId()));
        mv.addObject("entryForm", new EntryForm());
        mv.setViewName("entry/index");
        return mv;
    }

    @RequestMapping(value="/work", method=RequestMethod.POST)
    public ModelAndView registration(ModelAndView mv, @ModelAttribute EntryForm entryform, @AuthenticationPrincipal User userDetails){
        GuestDTO guestDto = modelMapper.map(entryform, GuestDTO.class);
        guestDto.setEsqId(userDetails.getEsqId());
        if(entryService.newEntry(guestDto)==0){
            mv.addObject("errorMessage","入力内容は既に申込済です");
            mv.setViewName("entry/index");
            return mv;
        }
        mv.addObject("entryContents", guestDto);
        mv.setViewName("redirect:/mypage");
        return mv;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="/ajaxwork", method=RequestMethod.POST)
    public boolean ajaxRegistration(@RequestPart ("jsonValue") EntryForm entryform, @AuthenticationPrincipal User userDetails){
        GuestDTO guestDto = modelMapper.map(entryform, GuestDTO.class);
        guestDto.setEsqId(userDetails.getEsqId());
        if(entryService.newEntry(guestDto)==0){
            return false;
        }
        return true;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="/cancel", method = RequestMethod.POST)
    public boolean ajaxCancel(@AuthenticationPrincipal User userDetails){
        GuestDTO guestDto = new GuestDTO();
        guestDto.setEsqId(userDetails.getEsqId());
        guestDto.setSeminarId(seminarService.findAcceptingSeminar().getSeminarId());
        if(entryService.cancelEntry(guestDto)==0){
            return false;
        }
        return true;
    }


}
