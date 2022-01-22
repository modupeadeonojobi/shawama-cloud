package com.imodupsy.shawamacloud.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author iModupsy
 * @created 22/01/2022
 */

@Data
@RequiredArgsConstructor
public class Ingredient {

    public enum Type {
        WRAP, PROTEIN, VEGGIES, SAUCE
    }

    private final String id;

    private final String name;

    private final Type type;


}


