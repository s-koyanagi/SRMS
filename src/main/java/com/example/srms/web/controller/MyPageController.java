package com.example.srms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("mypage/index");
        return mv;
    }

}