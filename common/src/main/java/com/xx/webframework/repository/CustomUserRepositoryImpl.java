package com.xx.webframework.repository;

import com.xx.webframework.domain.User;

public class CustomUserRepositoryImpl implements CustomUserRepository<User> {

    @Override
    public String sayHello(){
        return "hello";
    }
}
