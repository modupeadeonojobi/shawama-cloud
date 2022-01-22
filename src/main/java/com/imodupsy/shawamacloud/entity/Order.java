package com.imodupsy.shawamacloud.entity;

import lombok.Data;


/**
 * @author iModupsy
 * @created 22/01/2022
 */

@Data
public class Order {

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
