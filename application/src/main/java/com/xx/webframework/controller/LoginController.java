package com.xx.webframework.controller;

import com.xx.webframework.common.ResponseResult;
import com.xx.webframework.common.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseResult doLogin(LoginForm loginForm){
        log.info("loginForm:{}",JsonUtil.toJson(loginForm));
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode("SUCCESS");
        responseResult.setData("/home");
        return responseResult;
    }
}

@Getter
@Setter
class LoginForm{
    private String username;
    private String password;
}
