package com.imodupsy.shawamacloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author iModupsy
 * @created 25/01/2022
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("customUserDetailService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/design", "/orders").access("hasRole('USER')")
                .antMatchers("/", "/**").access("permitAll")

                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/design", true)

                .and()
                .logout()
                .logoutSuccessUrl("/")

                // Make H2-Console non-secured; for debug purposes
                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**")

                // Allow pages to be loaded in frames from the same origin; needed for H2-Console
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

    }












   /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                    .antMatchers("/design", "/orders").hasRole("USER")
                    .antMatchers("/", "/**").permitAll()

                .and()
                    .formLogin()
                        .loginPage("/login")
                *//** The route you want to navigate the users to immediately they are logged in. **//*
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

                *//** Never disable csrf(Cross-site request forgery). I disable it because of h2 database. **//*
                .and()
                    .csrf()
                        .ignoringAntMatchers("/h2-console/**")
//                .disable().headers().frameOptions().disable()

                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .build();
    }*/


}
