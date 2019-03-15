package com.example.srms.web.controller;

import com.example.srms.service.SeminarService;
import com.example.srms.web.form.IndexForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"","/","/index"})
public class IndexController {

    @Autowired
    SeminarService seminarService;

    @ModelAttribute
    public IndexForm initForm(){
        return new IndexForm();
    }

    @RequestMapping(value={""}, method= RequestMethod.GET)
    public ModelAndView index(ModelAndView mv){
        mv.addObject("seminar",seminarService.findAcceptingSeminar());
        mv.setViewName("index/index");
        return mv;
    }

}
