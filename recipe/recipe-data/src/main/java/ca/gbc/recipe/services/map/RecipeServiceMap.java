package ca.gbc.recipe.services.map;

import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceMap implements RecipeService {

    public Map<Long, Recipe> map = new HashMap<>();

    @Override
    public Set<Recipe> findAll() {
        return new HashSet(map.values());
    }

    @Override
    public Recipe findByName(String name) {
        return map.get(name);
    }

    @Override
    public Recipe create(Recipe recipe) {
        if (recipe != null) {
            if (recipe.getId() == null) {
                recipe.setId(getNextId());
            }
            map.put(recipe.getId(), recipe);
        } else {
            throw new RuntimeException("Recipe cannot be null");
        }
        return recipe;
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
