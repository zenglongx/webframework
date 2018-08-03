package com.xx.webframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("message","hello thymeleaf");
        return "home";
    }

}
