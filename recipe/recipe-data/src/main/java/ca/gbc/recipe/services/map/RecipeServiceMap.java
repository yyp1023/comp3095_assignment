package ca.gbc.recipe.services.map;

import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceMap extends AbstractServiceMap<Recipe, Long> implements RecipeService {
    @Override
    public Recipe save(Recipe object) {
        return super.save(object);
    }

    @Override
    public Set<Recipe> findAll() {
        return super.findAll();
    }

    @Override
    public Recipe findById(Long id) {
        return null;
    }

    @Override
    public Recipe findByName(String name) {
        return null;
    }
}
