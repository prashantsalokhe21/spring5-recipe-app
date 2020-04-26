package com.prashant21tube.springframework.controller;

import com.prashant21tube.springframework.domain.Category;
import com.prashant21tube.springframework.domain.Recipe;
import com.prashant21tube.springframework.domain.UnitOfMeasure;
import com.prashant21tube.springframework.repository.CategoryRepository;
import com.prashant21tube.springframework.repository.UnitOfMeasureRepository;
import com.prashant21tube.springframework.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.Set;

@Controller
public class IndexController {

	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final RecipeService recipeService;

	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.recipeService = recipeService;
	}

	@RequestMapping({"","/","/index"})
	public String getIndexPage() {
		Optional<Category> optionalCategory = categoryRepository.findByDescription("Fast Food");
		Optional<UnitOfMeasure> optionalUOM = unitOfMeasureRepository.findByDescription("Teaspoon");
		System.out.println("Category id is :"+optionalCategory.get().getId());
		System.out.println("UOM id is :" + optionalUOM.get().getId());
		System.out.println("This is my first project!!! 1234asd");
		return "index";
	}

	@RequestMapping({"/recipes"})
	public String getRecipes(Model model){
		Set<Recipe> recipes = recipeService.getRecipes();
		model.addAttribute("recipes", recipes);
		return "index";
	}
}
