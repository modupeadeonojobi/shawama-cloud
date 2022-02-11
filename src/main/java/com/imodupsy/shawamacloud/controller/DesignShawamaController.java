package com.imodupsy.shawamacloud.controller;

import com.imodupsy.shawamacloud.entity.Ingredient;
import com.imodupsy.shawamacloud.entity.Shawama;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author iModupsy
 * @created 22/01/2022
 */

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignShawamaController {


    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredientList = Arrays.asList(
                new Ingredient("SHBR", "Shawama Bread", Ingredient.Type.WRAP),
                new Ingredient("GRCH","Grilled Chicken", Ingredient.Type.PROTEIN),
                new Ingredient("GRBE","Grilled Beef", Ingredient.Type.PROTEIN),
                new Ingredient("DITO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("DION", "Diced Onions", Ingredient.Type.VEGGIES),
                new Ingredient("LETT", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("TAHI", "Tahini", Ingredient.Type.SAUCE),
                new Ingredient("YOSA", "Yogurt Sauce", Ingredient.Type.SAUCE)
        );


        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type: types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredientList, type));
        }
        model.addAttribute("shawama", new Shawama());
        return "design";
    }

    @PostMapping("/submit")
    public String processDesign(@Valid Shawama shawama, Errors errors) {

        if (errors.hasErrors()) {
            return "design";
        }
        log.info("Processing design: " + shawama);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
