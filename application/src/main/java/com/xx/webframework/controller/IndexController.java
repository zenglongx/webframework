package com.xx.webframework.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            return "redirect:/home";
        }else {
            return "redirect:/login";
        }
    }
}
