package com.example.srms.web.controller;


import com.example.srms.web.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"","/","/index"})
public class IndexController {

    // Init login form
    @ModelAttribute
    public LoginForm loginForm(){
        return new LoginForm();
    }

    // View login page
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public ModelAndView index(ModelAndView mv){
        mv.setViewName("index/index");
        return mv;
    }

    // Authentication error handler
    @RequestMapping(value = {"/login_error"}, method = RequestMethod.POST)
    public ModelAndView loginFailure(@ModelAttribute @Validated LoginForm form, BindingResult result, ModelAndView mv) {
        if(!result.hasErrors()) {
            mv.addObject("errorMessage", "ログイン情報が間違っています");
        }
        mv.setViewName("index/index");
        return mv;
    }


}
