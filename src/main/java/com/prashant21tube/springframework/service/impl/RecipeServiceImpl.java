package com.prashant21tube.springframework.service.impl;

import com.prashant21tube.springframework.domain.Recipe;
import com.prashant21tube.springframework.repository.RecipeRepository;
import com.prashant21tube.springframework.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet :: add);
        return recipeSet;
    }
}
