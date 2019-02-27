package com.xx.webframework;

import com.alibaba.dubbo.config.ProtocolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfiguration {

    @Bean("webserviceId")
    public ProtocolConfig webserviceProtocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setId("webserviceId");
        protocolConfig.setName("webservice");
        protocolConfig.setPort(8080);
        protocolConfig.setServer("jetty");
        return protocolConfig;
    }
    @Bean("dubboId")
    public ProtocolConfig dubboProtocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setId("dubboId");
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(8081);
        return protocolConfig;
    }
}
