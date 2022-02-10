package com.imodupsy.shawamacloud.config;

import com.imodupsy.shawamacloud.entity.User;
import com.imodupsy.shawamacloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author iModupsy
 * @created 09/02/2022
 */

@Component
public class AppStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        createUser();

    }


    private void createUser() {
        if (userRepository.findByEmail("mo@mailinator.com") == null) {
            userRepository.save(new User("Mo", passwordEncoder.encode("password"), "iModupsy", "mo@mailinator.com", "Oba way", "Kingdom", "Uk", "Z23009", "2349090909088"));

        }
    }
}
