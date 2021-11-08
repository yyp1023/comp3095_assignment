//* Project: < project name … >
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
//        * Description: Controller for User and the logics behind data manipulations of the user and the system


package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.User;
import ca.gbc.recipe.services.FavoriteService;
import ca.gbc.recipe.services.RecipeService;
import ca.gbc.recipe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RecipeService recipeService;
    @Autowired
    FavoriteService favoriteService;

    @RequestMapping({"", "/", "/index", "index.html"})
    public String listUser(Model model) {
//        model.addAttribute("users", userService.findAll());
        return "users/index";
    }

    @RequestMapping({"/profile"})
    public String showProfile(Model model) {
//        model.addAttribute("users", userService.findById());
        return "users/index";
    }


    @RequestMapping("/register")
    public String userCreate(Model model){
        User user = new User();
        model.addAttribute(user);
        return "users/register";
    }

    @RequestMapping(value = "/registered", method= RequestMethod.POST)
    public String success(@ModelAttribute("user") User user){
        userService.save(user);
        return "users/success";
    }

    @GetMapping(value= "/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/accountInfo")
    public String showProfile(Model model, Integer id, HttpSession session) {
        User user = (User)session.getAttribute("user");
        model.addAttribute("users", userService.getById(user.getId()));
        return "users/accountInfo";
    }

    @RequestMapping("/myRecipe")
    public String findRecipes(Model model, HttpSession session) {
        User user = (User)session.getAttribute("user");
        model.addAttribute("recipes", recipeService.findMyRecipe(user));
        return "users/myRecipe";
    }

    @RequestMapping("/myFavourite")
    public String findFavoriteRecipes(Model model, HttpSession session) {
        User user = (User)session.getAttribute("user");
        model.addAttribute("favorites", favoriteService.findMyFav(user));
        return "users/myFavourite";
    }
}
