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
//        * Description: Controller for planMeal and the logics behind data manipulations of the user and the system

package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.Favorites;
import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.services.FavoriteService;
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
import java.util.List;

@RequestMapping("/recipes")
@Controller
public class RecipeController {

    @Autowired
    RecipeService recipeService;
    @Autowired
    UserService userService;
    @Autowired
    FavoriteService favoriteService;

    @RequestMapping({"", "/", "/index", "index.html"})
    public String listUser(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/index";
    }

    @RequestMapping({"/view_recipe"})
    public String viewRecipe(Model model, ModelMap modelMap, @Param("keyword") String keyword){
        List<Recipe> listRecipes = recipeService.listAll(keyword);
        model.addAttribute("listRecipes", listRecipes);
        if(recipeService.listAll(keyword) == null){
            modelMap.put("err", "No Recipe found, try to search by name or description!");
            return "recipes/index";
        };
        Favorites favorite = new Favorites();
        model.addAttribute("favorite", favorite);
        model.addAttribute("keyword", keyword);
        return "recipes/index";
    }

    @RequestMapping(value = "/marked", method= RequestMethod.POST)
    public String markedAsFav(@ModelAttribute("favorite") Favorites favorites,
                              HttpSession session,
                              @Param("rec_id") Long rec_id){
        User user = (User)session.getAttribute("user");
        Recipe recipe = recipeService.getById(rec_id);

        favorites.setUser_fav(user);
        favorites.setRecipe_fav(recipe);
        favoriteService.save(favorites);
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
        User user = (User)session.getAttribute("user");
        recipe.setUser_id(user);
        recipeService.save(recipe);
        return "recipes/recipe_created";
    }
}
