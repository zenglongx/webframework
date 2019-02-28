package com.xx.webframework.repository;

import com.xx.webframework.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long>, CustomUserRepository<User> {

    @Query("select u from User u where u.id=:id")
    User userDetail(@Param("id") Long id);
}