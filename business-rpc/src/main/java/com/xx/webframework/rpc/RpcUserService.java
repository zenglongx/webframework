package com.xx.webframework.rpc;

import com.alibaba.dubbo.config.annotation.Service;
import com.xx.webframework.service.UserService;
import com.xx.webframework.service.impl.UserServiceImpl;

@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class RpcUserService extends UserServiceImpl implements UserService {
}
