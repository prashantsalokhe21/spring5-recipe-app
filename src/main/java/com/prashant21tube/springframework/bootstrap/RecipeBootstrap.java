package com.prashant21tube.springframework.bootstrap;

import com.prashant21tube.springframework.domain.*;
import com.prashant21tube.springframework.repository.CategoryRepository;
import com.prashant21tube.springframework.repository.RecipeRepository;
import com.prashant21tube.springframework.repository.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if(!pintUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }

        //Get Optional
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tablespoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaspoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();

        //Get Categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> indianCategoryOptional = categoryRepository.findByDescription("Indian");
        if(!indianCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");
        if(!italianCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");
        if(!fastFoodCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        //Get Optional
        Category americanCategory = americanCategoryOptional.get();
        Category indianCategory = indianCategoryOptional.get();
        Category italianCategory = italianCategoryOptional.get();
        Category fastFoodCategory = fastFoodCategoryOptional.get();

        //Guacamole
        Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setServings(4);
        guacamole.setDirection("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n");
        Notes guacNote = new Notes();
        guacNote.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados." +
                "Feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). You can get creative with homemade guacamole!" +
                "The simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of availability of other ingredients stop you from making guacamole." +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great." +
                "\n" +
                "\n" +
                "Read More : https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        guacamole.setNotes(guacNote);

        guacamole.getIngredient().add(new Ingredient("ripe avocado", new BigDecimal(2), eachUom));
        guacamole.getIngredient().add(new Ingredient("Kosher Salt", new BigDecimal(5), teaspoonUom));
        guacamole.getIngredient().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tablespoonUom));
        guacamole.getIngredient().add(new Ingredient("minced red onion or tiny sliced green onion", new BigDecimal(2), tablespoonUom));
        guacamole.getIngredient().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom));
        guacamole.getIngredient().add(new Ingredient("Cilantro", new BigDecimal(2), tablespoonUom));
        guacamole.getIngredient().add(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashUom));
        guacamole.getIngredient().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(5), eachUom));

        guacamole.getCategory().add(americanCategory);

        //Add recipe to list
        recipes.add(guacamole);

        //Spicy grilled chicken tacos
        Recipe spicyChicken = new Recipe();
        spicyChicken.setDescription("Spicy Grilled Chicken Tacos");
        spicyChicken.setPrepTime(20);
        spicyChicken.setCookTime(15);
        spicyChicken.setServings(4);
        spicyChicken.setDifficulty(Difficulty.EASY);
        spicyChicken.setDirection("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

        Notes spicyChickenNotes = new Notes();
        spicyChickenNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house." +
                "\n" +
                "Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings");

        spicyChicken.setNotes(spicyChickenNotes);

        spicyChicken.getIngredient().add(new Ingredient("ancho chili powder", new BigDecimal(2), tablespoonUom));
        spicyChicken.getIngredient().add(new Ingredient("dried oregano", new BigDecimal(1), teaspoonUom));
        spicyChicken.getIngredient().add(new Ingredient("dried cumin", new BigDecimal(1), teaspoonUom));
        spicyChicken.getIngredient().add(new Ingredient("sugar", new BigDecimal(1), teaspoonUom));
        spicyChicken.getIngredient().add(new Ingredient("salt", new BigDecimal(1/2), teaspoonUom));
        spicyChicken.getIngredient().add(new Ingredient("clove garlic, finely chopped", new BigDecimal(1), eachUom));
        spicyChicken.getIngredient().add(new Ingredient("finely grated orange zest", new BigDecimal(1), tablespoonUom));
        spicyChicken.getIngredient().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoonUom));
        spicyChicken.getIngredient().add(new Ingredient("olive oil", new BigDecimal(2), tablespoonUom));
        spicyChicken.getIngredient().add(new Ingredient("boneless chicken thighs", new BigDecimal(4), tablespoonUom));

        spicyChicken.getIngredient().add(new Ingredient("corn tortillas", new BigDecimal(8), eachUom));
        spicyChicken.getIngredient().add(new Ingredient("packed baby arugula", new BigDecimal(3), cupUom));
        spicyChicken.getIngredient().add(new Ingredient("ripe avocados, sliced", new BigDecimal(2), eachUom));
        spicyChicken.getIngredient().add(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachUom));
        spicyChicken.getIngredient().add(new Ingredient("cherry tomatoes, halved", new BigDecimal(1/2), pintUom));
        spicyChicken.getIngredient().add(new Ingredient("red onion, thinly sliced", new BigDecimal(1/4), eachUom));
        spicyChicken.getIngredient().add(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), tablespoonUom));
        spicyChicken.getIngredient().add(new Ingredient("sour cream", new BigDecimal(1/2), cupUom));
        spicyChicken.getIngredient().add(new Ingredient("milk", new BigDecimal(1/4), cupUom));

        spicyChicken.getCategory().add(americanCategory);
        spicyChicken.getCategory().add(italianCategory);
        recipes.add(spicyChicken);

        return recipes;
    }


}
