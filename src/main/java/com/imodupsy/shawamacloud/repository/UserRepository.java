package com.imodupsy.shawamacloud.repository;

import com.imodupsy.shawamacloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author iModupsy
 * @created 25/01/2022
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);
}

