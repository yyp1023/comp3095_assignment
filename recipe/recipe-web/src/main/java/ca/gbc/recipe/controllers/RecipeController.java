package ca.gbc.recipe.controllers;

import ca.gbc.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/recipes")
@Controller
public class RecipeController {

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listRecipe(Model model) {
        //model.addAttribute("recipes", recipeService.findAll());
        return "recipes/index";
    }
}
