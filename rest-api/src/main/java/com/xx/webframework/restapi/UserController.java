package com.xx.webframework.restapi;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xx.webframework.domain.User;
import com.xx.webframework.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {

//    @Autowired
//    UserService userService;

    @Reference(version = "${user.service.version}",
            application = "${dubbo.application.id}"/*,
            url = "dubbo://localhost:12345"*/)
    UserService rpcUserService;

    @RequestMapping(method = RequestMethod.GET,value = "/user/list")
    public List<User> getUserList(){
        return rpcUserService.findAll();
    }
}
