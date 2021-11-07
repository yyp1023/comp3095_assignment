package ca.gbc.recipe.services;

import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository repo;

    public void save(Recipe object) {
        repo.save(object);
    }

    public List<Recipe> findAll() {
        return repo.findAll();
    }

    public List<Recipe> findByName(String name) {
        return findByName(name);

    }

}