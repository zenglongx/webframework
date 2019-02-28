package com.xx.webframework.repository;

import com.xx.webframework.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>, CustomUserRepository<User> {

}