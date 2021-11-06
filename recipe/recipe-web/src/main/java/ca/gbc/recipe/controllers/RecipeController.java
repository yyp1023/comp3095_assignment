package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/recipes")
@Controller
public class RecipeController {


    @RequestMapping({"/view_recipe"})
    public String listRecipe(Model model) {
        //model.addAttribute("recipes", recipeService.findAll());
        return "recipes/index";
    }

    @RequestMapping("/createRecipe")
    public String userCreate(Model model){
        User user = new User();
        model.addAttribute(user);
        return "recipes/createRecipe";
    }
}
