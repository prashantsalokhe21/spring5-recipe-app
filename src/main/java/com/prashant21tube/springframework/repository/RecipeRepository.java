package com.prashant21tube.springframework.repository;

import com.prashant21tube.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
