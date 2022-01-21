package com.imodupsy.shawamacloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author iModupsy
 * @created 21/01/2022
 */

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
