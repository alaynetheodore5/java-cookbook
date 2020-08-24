package com.alaynetheodore.cookbook.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alaynetheodore.cookbook.models.Ingredient;


@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	
	Optional<Ingredient> findByName(String name);
	
}