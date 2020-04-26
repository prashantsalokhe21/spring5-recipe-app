package com.prashant21tube.springframework.service;

import com.prashant21tube.springframework.domain.Recipe;

import java.util.Set;


public interface RecipeService {

    Set<Recipe> getRecipes();
}
