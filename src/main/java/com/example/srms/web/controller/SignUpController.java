package com.example.srms.web.controller;

import com.example.srms.domain.dto.SignUpDTO;
import com.example.srms.service.SignUpService;
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

    @Autowired
    SignUpService signUpService;

    @RequestMapping(value={"/","/index"},method= RequestMethod.GET)
    public ModelAndView index(ModelAndView mv){
        mv.addObject("signUpForm",new SignUpForm());
        mv.setViewName("signup/index");
        return mv;
    }

    @RequestMapping(value={"/work"},method=RequestMethod.POST)
    public ModelAndView registration(ModelAndView mv, @ModelAttribute SignUpForm signUpForm){
        SignUpDTO signUpDto = new SignUpDTO();
        signUpDto = modelMapper.map(signUpForm, signUpDto.getClass());
        if(signUpService.userRegistration(signUpDto).getIsRegister()==0){
            mv.addObject("errorMessage","入力されたESQIDは既に登録済みです");
            mv.setViewName("signup/index");
            return mv;
        }
        mv.addObject("signupContents", signUpDto);
        mv.setViewName("signup/confirm");
        return mv;
    }
}
