package com.imodupsy.shawamacloud.entity;

import com.imodupsy.shawamacloud.constant.MessageConstant;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


/**
 * @author iModupsy
 * @created 22/01/2022
 */

@Data
public class Order {

    @NotBlank(message = MessageConstant.INVALID_NAME)
    private String name;

    @NotBlank(message = MessageConstant.INVALID_STREET)
    private String street;

    @NotBlank(message = MessageConstant.INVALID_CITY)
    private String city;

    @NotBlank(message = MessageConstant.INVALID_STATE)
    private String state;

    @NotBlank(message = MessageConstant.INVALID_ZIP_CODE)
    private String zip;

    @CreditCardNumber(message = MessageConstant.INVALID_CREDIT_CARD)
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = MessageConstant.INVALID_EXPIRATION)
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = MessageConstant.INVALID_CVV)
    private String ccCVV;

    private List<Shawama> shawamaList = new ArrayList<>();

    public void addShawama(Shawama shawama) {
        this.shawamaList.add(shawama);
    }
}
