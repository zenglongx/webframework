package com.xx.webframework.app.controller;

import com.xx.webframework.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Resource
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        System.out.println(userService.findAll());
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            return "redirect:/home";
        }else {
            return "redirect:/login";
        }
    }
}
