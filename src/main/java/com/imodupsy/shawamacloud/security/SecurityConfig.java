package com.imodupsy.shawamacloud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author iModupsy
 * @created 25/01/2022
 */

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                    .antMatchers("/design", "/orders").hasRole("USER")
                    .antMatchers("/", "/**").permitAll()

                .and()
                    .formLogin()
                        .loginPage("/login")
                /** The route you want to navigate the users to immediately they are logged in. **/
                        .defaultSuccessUrl("/design", true)
                        .loginProcessingUrl("/authenticate")
                        .usernameParameter("/user")
                        .passwordParameter("/password")

                .and()
                    .oauth2Login()
                        .loginPage("/login")
                        .defaultSuccessUrl("/design", true)

                .and()
                    .logout()
                    .logoutSuccessUrl("/")

                /** Never disable csrf(Cross-site request forgery). I disable it because of h2 database. **/
                .and()
                    .csrf().disable().headers().frameOptions().disable()

                .and()
                .build();
    }


}
