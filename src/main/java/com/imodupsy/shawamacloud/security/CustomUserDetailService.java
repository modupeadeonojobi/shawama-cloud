package com.imodupsy.shawamacloud.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author iModupsy
 * @created 25/01/2022
 */
public interface CustomUserDetailService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
