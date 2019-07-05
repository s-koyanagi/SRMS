package com.example.srms.web.controller;

import com.example.srms.domain.entity.User;
import com.example.srms.service.AdminService;
import com.example.srms.service.DashboardService;
import com.example.srms.service.SeminarService;
import com.example.srms.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
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
        editableSeminar.put("speaker", speakerService.findSpeaker(seminarId));
        return editableSeminar;
    }
}
