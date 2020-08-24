package com.alaynetheodore.cookbook.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alaynetheodore.cookbook.models.Recipe;


@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {}
