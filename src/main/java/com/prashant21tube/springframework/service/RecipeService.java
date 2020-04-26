package com.prashant21tube.springframework.service;

import com.prashant21tube.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService extends CrudRepository<Recipe, Long> {

}
