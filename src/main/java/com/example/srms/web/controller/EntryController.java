package com.example.srms.web.controller;

import com.example.srms.domain.dto.GuestInfoDto;
import com.example.srms.service.EntryService;
import com.example.srms.service.SeminarService;
import com.example.srms.web.form.EntryForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/entry"})
public class EntryController {

    @Autowired
    SeminarService seminarService;

    @Autowired
    EntryService entryService;

    @Autowired
    ModelMapper modelMapper;


    @ModelAttribute
    public EntryForm entryForm(){
        return new EntryForm();
    }


    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv){
        mv.addObject("seminar_id",seminarService.findAcceptingSeminar().getSeminar_id());
        mv.setViewName("entry/index");
        return mv;
    }

    @RequestMapping(value="/work", method=RequestMethod.POST)
    public ModelAndView registration(ModelAndView mv,EntryForm form){
        GuestInfoDto guestInfoDto = new GuestInfoDto();
        guestInfoDto = modelMapper.map(form, guestInfoDto.getClass());
        if(entryService.newEntry(guestInfoDto)==0){
            mv.addObject("errorMessage","入力内容は既に申込済です");
            mv.setViewName("entry/index");
            return mv;
        }
        mv.addObject("entryContents", guestInfoDto);
        mv.setViewName("entry/confirm");
        return mv;
    }

}
