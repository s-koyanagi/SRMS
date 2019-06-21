package com.example.srms.web.controller;

import com.example.srms.domain.dto.SeminarDTO;
import com.example.srms.domain.entity.Seminar;
import com.example.srms.domain.entity.User;
import com.example.srms.service.DashboardService;
import com.example.srms.service.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DashboardService dashboardService;

    @Autowired
    SeminarService seminarService;

    @RequestMapping(value={""}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv, @AuthenticationPrincipal User userDetails){
        mv.addObject("analyticsData",dashboardService.getAnalyticsData());
        mv.addObject("userDetails",userDetails);
        mv.setViewName("admin/index");
        return mv;
    }

    @RequestMapping(value={"/seminarlist"}, method = RequestMethod.GET)
    public ModelAndView showSeminarList(ModelAndView mv, @AuthenticationPrincipal User userDetails){
        mv.addObject("seminarList",seminarService.getAllSeminarList());
        mv.setViewName("admin/seminarList");
        mv.addObject("userDetails",userDetails);
        return mv;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value={"/getseminar/{seminarId}"}, method = RequestMethod.GET)
    public SeminarDTO getSeminarInfo(@PathVariable("seminarId") int seminarId){
        SeminarDTO seminarDTO = seminarService.findSeminar(seminarId);
        return seminarDTO;
    }
}
