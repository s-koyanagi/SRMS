package com.example.srms.web.controller;

import com.example.srms.domain.dto.SeminarDTO;
import com.example.srms.domain.dto.SpeakerDTO;
import com.example.srms.domain.entity.User;
import com.example.srms.service.AdminService;
import com.example.srms.service.DashboardService;
import com.example.srms.service.SeminarService;
import com.example.srms.service.SpeakerService;
import com.example.srms.web.form.SeminarForm;
import com.example.srms.web.form.SpeakerForm;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DashboardService dashboardService;

    @Autowired
    SeminarService seminarService;

    @Autowired
    AdminService adminService;

    @Autowired
    SpeakerService speakerService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value={""}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv, @AuthenticationPrincipal User userDetails){
        mv.addObject("analyticsData",dashboardService.getAnalyticsData());
        mv.addObject("userDetails",userDetails);
        mv.setViewName("admin/index");
        return mv;
    }

    @RequestMapping(value={"/seminarlist"}, method = RequestMethod.GET)
    public ModelAndView seminarList(ModelAndView mv, @AuthenticationPrincipal User userDetails){
        mv.addObject("seminarList",seminarService.getAllSeminarList());
        mv.setViewName("admin/seminarList");
        mv.addObject("userDetails",userDetails);
        return mv;
    }

    @RequestMapping(value={"/seminardetails/{seminarId}"}, method = RequestMethod.GET)
    public ModelAndView getSeminarDetails(ModelAndView mv, @PathVariable("seminarId") int seminarId){
        mv.addObject("seminar", adminService.getSeminarInfo(seminarId));
        mv.addObject("speakerList", speakerService.findSpeaker(seminarId));
        mv.addObject("guestList", adminService.getGuestList(seminarId));
        mv.setViewName("admin/seminarDetails");
        return mv;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value={"/editableseminar/{seminarId}"}, method= RequestMethod.GET)
    public Map<String, Object> getEditableSeminar(@PathVariable("seminarId") int seminarId){
        Map<String, Object> editableSeminar = new HashMap<>();
        editableSeminar.put("seminar", adminService.getSeminarInfo(seminarId));
        editableSeminar.put("speakers", speakerService.findSpeaker(seminarId));
        return editableSeminar;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="/applyedits", method=RequestMethod.POST)
    public Map<String, Object> applyEdits(@RequestPart ("seminarValue") SeminarForm seminarForm,
                                    @RequestPart ("speakerValue") List<SpeakerForm> speakerFormList,
                                    @AuthenticationPrincipal User userDetails){
        Map updateContents = new HashMap();
        SeminarDTO seminarDTO = modelMapper.map(seminarForm, SeminarDTO.class);
        List<SpeakerDTO> speakerDTOList = modelMapper.map(speakerFormList,new TypeToken<List<SpeakerDTO>>() {}.getType());
        if(adminService.registration(seminarDTO,speakerDTOList)){
            updateContents.put("seminar",seminarDTO);
            updateContents.put("speakers",speakerDTOList);
            return updateContents;
        }
        return updateContents;
    }

}
