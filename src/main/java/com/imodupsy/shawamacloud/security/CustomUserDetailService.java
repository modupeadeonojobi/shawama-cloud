package com.imodupsy.shawamacloud.security;

import com.imodupsy.shawamacloud.entity.User;
import com.imodupsy.shawamacloud.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author iModupsy
 * @created 25/01/2022
 */

@Configuration
public class CustomUserDetailService {


    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) return user;

            throw new UsernameNotFoundException("User " + username + " not found");
        };
    }
}
