package ca.gbc.recipe.services;

import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
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

    public List<Recipe> findByName(String name) {
        return findByName(name);
    }

    public List<Recipe> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.isPublic();
    }

    public List<Recipe> findAll() {
        return  repo.findAll();
    }

    public List<Recipe> findMyRecipe(User user_id){ return repo.findByUser_id(user_id);}

    public Recipe getById(Long id) { return repo.getById(id); }
}
