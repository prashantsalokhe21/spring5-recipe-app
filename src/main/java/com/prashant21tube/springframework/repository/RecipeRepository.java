package com.prashant21tube.springframework.repository;

import com.prashant21tube.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Override
    Iterable<Recipe> findAll();
}
