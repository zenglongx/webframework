package com.xx.webframework.app;

import com.xx.webframework.repository.BaseRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;

@SpringBootApplication
@Slf4j
@ControllerAdvice
@Configuration
@ComponentScan({"com.xx.webframework"})
@EntityScan(basePackages = "com.xx.webframework.domain")
@EnableJpaRepositories(basePackages = "com.xx.webframework.repository", basePackageClasses = BaseRepositoryImpl.class)
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }

//    @Bean
//    public RepositoryRestConfigurerAdapter repositoryRestConfigurerAdapter(){
//        return new RepositoryRestConfigurerAdapter(){
//            @Override
//            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//                super.configureRepositoryRestConfiguration(config);
//                config.useHalAsDefaultJsonMediaType(false);
//                config.setDefaultMediaType(MediaType.APPLICATION_JSON_UTF8);
//            }
//        };
//    }

}
