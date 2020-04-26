package com.prashant21tube.springframework.service;

import com.prashant21tube.springframework.domain.Ingredient;
import org.springframework.stereotype.Service;

@Service
public interface IngredientService extends CrudService<Ingredient, Long> {
}
