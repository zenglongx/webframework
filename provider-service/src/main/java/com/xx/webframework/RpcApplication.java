package com.xx.webframework;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("spring-dubbo.xml")
public class RpcApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RpcApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
