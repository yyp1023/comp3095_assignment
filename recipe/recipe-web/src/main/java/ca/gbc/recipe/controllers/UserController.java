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
//        * Description: Controller for User and the logics behind data manipulations of the user and the system


package ca.gbc.recipe.controllers;
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    @Autowired
    CartService cartService;
    @Autowired
    PlanMealService planMealService;


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
    public String success(@ModelAttribute("user") User user,  HttpSession session){
        userService.save(user);
        session.setAttribute("user", user);
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

        if (ObjectUtils.isEmpty(recipeService.findMyRecipe(user))){
            model.addAttribute("error", "There's no recipe in the meantime");
        }
        else{
            model.addAttribute("recipes", recipeService.findMyRecipe(user));
            model.addAttribute("user_id", user.getId());
        }
        return "users/myRecipe";
    }

    @RequestMapping("/myFavourite")
    public String findFavoriteRecipes(Model model, HttpSession session, RedirectAttributes redirAttrs) {
        User user = (User)session.getAttribute("user");

        if (ObjectUtils.isEmpty(favoriteService.findMyFav(user))){
            model.addAttribute("error", "There's no favorite in the meantime");
        }
        else{
            model.addAttribute("favorites", favoriteService.findMyFav(user));
        }
        return "users/myFavourite";
    }

    @RequestMapping("/myCart")
    public String findShoppingCart(Model model, HttpSession session, RedirectAttributes redirAttrs) {
        User user = (User)session.getAttribute("user");

        if (ObjectUtils.isEmpty(cartService.findMyShoppingCart(user))){
            model.addAttribute("error", "Your shopping list is empty");
        }
        else{
            model.addAttribute("ShoppingCart", cartService.findMyShoppingCart(user));
        }
        return "users/myCart";
    }

    @RequestMapping("deleteMyFav/{sid}")
    public String deleteMyFav(@PathVariable(name="sid") Long sid, HttpSession session) {
        favoriteService.deleteUsersByRecipe(sid);
        return "redirect:/users/myFavourite";
    }
    @RequestMapping("deleteMyRecipe/{sid}")
    public String deleteMyRecipe(@PathVariable(name="sid") Long sid, HttpSession session) {
        recipeService.deleteMyRecipe(sid);
        return "redirect:/users/myRecipe";
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(Model model, HttpSession session) {
        return "users/resetPassword";
    }


    @RequestMapping(value = {"/resetPassword"}, method = RequestMethod.POST)
    public String passwordReset(Model model, HttpSession session, @Param("newPassword") String newPassword,
                                @Param("newPassword") String oldPassword, @Param("newPassword") String confirmPassword,
                                ModelMap modelMap)  {
        User user = (User)session.getAttribute("user");
        User acc = userService.getById(user.getId());

        model.addAttribute("newPassword", newPassword);
        model.addAttribute("confirmPassword", confirmPassword);
        model.addAttribute("oldPassword", oldPassword);

        if (acc.getPassword().equalsIgnoreCase(oldPassword)) {
            if (confirmPassword.equalsIgnoreCase(newPassword)) {
                acc.setPassword(confirmPassword);
                userService.save(acc);
                return "redirect:/users/index";
            } else {
                modelMap.put("error", "Password Error");
                return "/users/resetPassword";
            }
        } else {
            modelMap.put("error", "Password Error");
            return "/users/resetPassword";
        }
    }

    @RequestMapping(value = "/update/{id}")
    public String profileUpdate(@PathVariable(name="id") Long id ,Model model){
        User user = userService.getById(id);
        model.addAttribute("id", id);
        model.addAttribute("users", userService.getById(user.getId()));
        model.addAttribute("user_id", user.getId());
        return "users/updateProfile";
    }

    @PostMapping(value = "/update/{id}")
    public String updating(@PathVariable(name="id") Long id, @Param("firstname") String firstname,
                           @Param("lastname") String lastname, @Param("username") String username, Model model){

        User user = userService.getById(id);
        model.addAttribute("users");
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        userService.save(user);
        System.out.println(firstname);
        System.out.println(id);
        return "redirect:/users/accountInfo";
    }
}
