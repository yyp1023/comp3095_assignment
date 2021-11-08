package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.services.RecipeService;
import ca.gbc.recipe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequestMapping("/recipes")
@Controller
public class RecipeController {

    @Autowired
    RecipeService recipeService;
    UserService userService;

    @RequestMapping({"/view_recipe"})
    public String viewRecipe(Model model, @Param("keyword") String keyword) {
        List<Recipe> listRecipes = recipeService.listAll(keyword);
        model.addAttribute("listRecipes", listRecipes);
        model.addAttribute("keyword", keyword);
        return "recipes/index";
    }

    @RequestMapping("/createRecipe")
    public String createRecipe(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "recipes/createRecipe";
    }

    @RequestMapping(value = "/recipe_created", method= RequestMethod.POST)
    public String success(@ModelAttribute("recipe") Recipe recipe,
                          HttpSession session, ModelMap modelMap,
                          Model model){
        model.addAttribute("recipe", recipe);
        session.getAttribute("username");
        recipe.setDateCreated(LocalDate.now());
        recipeService.save(recipe);
        return "recipes/recipe_created";
    }
}
