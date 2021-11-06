package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.LocalTime;

@RequestMapping("/recipes")
@Controller
public class RecipeController {

    @Autowired
    RecipeService recipeService;


    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listRecipe(Model model) {
        //model.addAttribute("recipes", recipeService.findAll());
        return "recipes/index";
    }

    @RequestMapping("/createRecipe")
    public String createRecipe(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe",recipe);
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("time", LocalTime.now());
        return "recipes/createRecipe";
    }

    @RequestMapping(value = "/recipe_created", method= RequestMethod.POST)
    public String success(@ModelAttribute("recipe") Recipe recipe){
        recipeService.save(recipe);
        /*
         * database codes here
         *
         * */
        return "recipes/recipe_created";
    }
}
