//* Project: < Recipe >
//        * Assignment: < assignment 1 >
//        * Author(s): < Young Pyung Yoo>
//                     < Kent Pedrocha >
//                     < John Jademar Lopez>
//                     <Mark Romel Trespeces>
//        * Student Number: < 101254379 >
//                          < 101266723 >
//                          < 101231787 >
//                          < 101258258 >
//        * Date: November 7, 2021
//        * Description: Service operations for Recipe

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
    public Recipe findRecipeById(Long id) { return repo.findRecipeById(id); }


    public void deleteMyRecipe(Long id) {
        repo.deleteMyRecipe(id);
    }
}
