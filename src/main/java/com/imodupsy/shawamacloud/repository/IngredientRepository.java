package com.imodupsy.shawamacloud.repository;

import com.imodupsy.shawamacloud.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author iModupsy
 * @created 24/01/2022
 */
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
