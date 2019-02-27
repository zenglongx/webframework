package com.xx.webframework.service.impl;

import com.xx.webframework.domain.User;
import com.xx.webframework.repository.UserRepository;
import com.xx.webframework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
//        return userRepository.findAll(PageRequest.of(0,10)).getContent();
        return Arrays.asList(new User());
    }
}