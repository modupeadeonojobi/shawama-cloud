package com.imodupsy.shawamacloud.controller;

import com.imodupsy.shawamacloud.entity.OrderShawama;
import com.imodupsy.shawamacloud.entity.Shawama;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * @author iModupsy
 * @created 22/01/2022
 */

@Controller
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new OrderShawama());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid OrderShawama order, Errors errors) {
        System.out.println("REching here");
        if (errors.hasErrors()) {
            System.out.println("Error here");

            return "orderForm";
        }
        log.info("Order submitted: " + order);
        return "redirect:/";
    }


}
