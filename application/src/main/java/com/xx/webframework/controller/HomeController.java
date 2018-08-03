package com.xx.webframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("message","hello thymeleaf");
        return "home";
    }

    @RequestMapping(value = "welcome")
    public String welcome(){
        return "login";
    }

}
