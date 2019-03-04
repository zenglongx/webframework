package com.xx.webframework.search;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

interface PersonRepository extends ElasticsearchRepository<Person,String>{

}