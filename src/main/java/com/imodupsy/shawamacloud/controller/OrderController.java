package com.imodupsy.shawamacloud.controller;

import com.imodupsy.shawamacloud.entity.OrderShawama;
import com.imodupsy.shawamacloud.entity.User;
import com.imodupsy.shawamacloud.repository.OrderRepository;
import com.imodupsy.shawamacloud.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
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
@AllArgsConstructor
public class OrderController {

    private OrderRepository orderRepository;

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new OrderShawama());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid OrderShawama order, Errors errors,
                               SessionStatus sessionStatus, @AuthenticationPrincipal User user) {

        if (errors.hasErrors()) {
            System.out.println("Error here");

            return "orderForm";
        }

        orderRepository.save(order);
        sessionStatus.setComplete();
        log.info("Order submitted: " + order);
        return "redirect:/";
    }


}