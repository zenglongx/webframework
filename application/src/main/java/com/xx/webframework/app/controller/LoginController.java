package com.xx.webframework.app.controller;

import com.xx.webframework.app.common.ResponseResult;
import com.xx.webframework.app.common.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult doLogin(LoginForm loginForm){
        log.info("loginForm:{}",JsonUtil.toJson(loginForm));

        ResponseResult responseResult = new ResponseResult();
        UsernamePasswordToken token = new UsernamePasswordToken(loginForm.getUsername(), loginForm.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            responseResult.setCode("SUCCESS");
            responseResult.setData("/home");
        } catch (AuthenticationException e) {
            responseResult.setCode("ERROR");
            responseResult.setData("/home");
        }
        return responseResult;
    }
}

@Getter
@Setter
class LoginForm{
    private String username;
    private String password;
}
