package com.example.srms.web.controller;

import com.example.srms.web.form.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/signup"})
public class SignUpController {

    @ModelAttribute
    public SignUpForm signUpForm(){return new SignUpForm();}

    @RequestMapping(value={"/","/index"},method= RequestMethod.GET)
    public ModelAndView index(ModelAndView mv){
        mv.setViewName("signup/index");
        return mv;
    }
}
