package com.imodupsy.shawamacloud.entity;

import com.imodupsy.shawamacloud.constant.MessageConstant;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



/**
 * @author iModupsy
 * @created 22/01/2022
 */

@Data
@Entity
public class Shawama {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5, message = MessageConstant.INVALID_NAME_CHARACTER)
    private String name;

    @NotNull
    @Size(min = 1, message = MessageConstant.INVALID_INGREDIENT)
    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;


    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

}
