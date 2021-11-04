package ca.gbc.recipe.services;

import ca.gbc.recipe.model.Recipe;

import java.util.Set;

public interface RecipeService extends CrudService<Recipe> {
    Set<Recipe> findAll();
    Recipe findByName(String name);
}
