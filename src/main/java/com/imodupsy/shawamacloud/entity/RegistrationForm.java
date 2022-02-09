package com.imodupsy.shawamacloud.entity;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author iModupsy
 * @created 25/01/2022
 */

@Data
public class RegistrationForm {

    private String username;

    private String password;

    private String fullName;

    private String email;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username, passwordEncoder.encode(password),
                fullName, email,  street, city, state, zip, phoneNumber
        );

    }

}
