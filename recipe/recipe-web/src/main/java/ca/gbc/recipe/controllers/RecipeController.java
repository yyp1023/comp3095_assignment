package ca.gbc.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/recipes")
@Controller
public class RecipeController {


    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listRecipe(Model model) {
        //model.addAttribute("recipes", recipeService.findAll());
        return "recipes/index";
    }
}
