package com.xx.webframework.service.impl;

import com.xx.webframework.domain.User;
import com.xx.webframework.repository.UserRepository;
import com.xx.webframework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>((int)userRepository.count());
        userRepository.findAll().forEach(u -> list.add(u));
        System.out.println(userRepository.sayHello());
        return list;
    }
}