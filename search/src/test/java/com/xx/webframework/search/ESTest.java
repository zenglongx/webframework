package com.xx.webframework.search;

import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ESTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void exampleTest(){
        Assert.assertTrue(true);
        Assert.assertNotNull(elasticsearchTemplate);
        Assert.assertNotNull(personRepository);

        Person person = new Person();
        person.setName("张三");
        person.setBirthday(Date.from(Instant.now()));
        person.setAddress("北京市昌平区沙河镇");
        person.setSex(1);
        personRepository.save(person);

//        System.out.println("findById                       : " + personRepository.findById(1L));

        System.out.println("findAll                        : " + personRepository.findAll());
        Page<Person> page = personRepository.search(new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withFields("name")
                .withQuery(QueryBuilders.matchQuery("name","张三"))
                .withPageable(PageRequest.of(0,10)).build());

        System.out.println("search page                    : " + page);


        System.out.println("template indexExists           : " + elasticsearchTemplate.indexExists(Person.class));

        List<Person> personList = elasticsearchTemplate.queryForList(new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())
                .withFields("name")
                .withQuery(QueryBuilders.matchQuery("address","北京朝阳"))
                        .build()
                ,Person.class);
        System.out.println("template search list by address 1  : " + personList);

        personList = elasticsearchTemplate.queryForList(new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())
                .withFields("name")
                .withQuery(QueryBuilders.multiMatchQuery("北京朝阳","address"))
                        .build()
                ,Person.class);
        System.out.println("template search list by address 2  : " + personList);

        personList = elasticsearchTemplate.queryForList(new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())
                .withFields("name")
                .withQuery(QueryBuilders.termQuery("address","北京"))
                        .build()
                ,Person.class);
        System.out.println("template search list by address 3  : " + personList);

        personList = elasticsearchTemplate.queryForList(new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())
                .withFields("name","id","birthday","address","sex")
                .withQuery(QueryBuilders.matchPhraseQuery("address","昌平"))
                        .build()
                ,Person.class);
        System.out.println("template search list by address 4  : " + personList);

        personList = elasticsearchTemplate.queryForList(new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())
                .withFields("name")
                .withQuery(QueryBuilders.termQuery("id",1))
                        .build()
                ,Person.class);
        System.out.println("template search list by address 5  : " + personList);

        personList = elasticsearchTemplate.queryForList(new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())
                .withFields("name")
                .withQuery(QueryBuilders.termQuery("name","张三"))
                        .build()
                ,Person.class);
        System.out.println("template search list by address 6  : " + personList);
    }

}

