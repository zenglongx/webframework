package com.xx.webframework.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Configuration
public class SearchApplication {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class);
    }

    @PostConstruct
    public void init(){
        // update mapping
        System.out.println("before   template indexExists  : " + elasticsearchTemplate.indexExists(Person.class));
        elasticsearchTemplate.deleteIndex(Person.class);
        elasticsearchTemplate.createIndex(Person.class);
    }
}
