package com.xx.webframework.repository;

import com.xx.webframework.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User,Long> {

    Page<User> findAll(Pageable pageable);

}