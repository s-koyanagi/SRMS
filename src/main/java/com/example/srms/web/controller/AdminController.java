package com.example.srms.web.controller;

import com.example.srms.domain.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // View login page
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public ModelAndView index(ModelAndView mv, @AuthenticationPrincipal User userDetails){
        return mv;
    }
}
