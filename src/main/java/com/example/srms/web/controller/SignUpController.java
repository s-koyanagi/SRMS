package com.example.srms.web.controller;

import com.example.srms.domain.dto.UserInfoDto;
import com.example.srms.web.form.SignUpForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/signup"})
public class SignUpController {

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value={"/","/index"},method= RequestMethod.GET)
    public ModelAndView index(ModelAndView mv){
        mv.addObject("signUpForm",new SignUpForm());
        mv.setViewName("signup/index");
        return mv;
    }

    @RequestMapping(value={"/work"},method=RequestMethod.POST)
    public ModelAndView registration(ModelAndView mv, @ModelAttribute SignUpForm signUpForm){
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto = modelMapper.map(signUpForm,userInfoDto.getClass());

        return mv;
    }
}
