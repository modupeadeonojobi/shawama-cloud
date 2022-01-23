package com.imodupsy.shawamacloud.entity;

import com.imodupsy.shawamacloud.constant.MessageConstant;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;



/**
 * @author iModupsy
 * @created 22/01/2022
 */

@Data
public class Shawama {

    @NotNull
    @Size(min = 5, message = MessageConstant.INVALID_NAME_CHARACTER)
    private String name;

    @NotNull
    @Size(min = 1, message = MessageConstant.INVALID_INGREDIENT)
    private List<String> Ingredients;
}
