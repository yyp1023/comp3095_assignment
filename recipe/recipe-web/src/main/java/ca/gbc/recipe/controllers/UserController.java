package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.User;
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

    @RequestMapping({"", "/", "/index", "index.html"})
    public String listUser(Model model) {
//        model.addAttribute("users", userService.findAll());
        return "users/index";
    }


//        model.addAttribute("users", userService.findById());    @RequestMapping({"", "/", "/index", "index.html"})
    @RequestMapping({"/profile"})
    public String home(){
        return "users/index";
    }



    public String showProfile(Model model) {
        return " ";
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
    public String accountInfo(){
        return "users/accountInfo";
    }

    @RequestMapping("/myRecipe")
    public String myRecipe(){
        return "users/myRecipe";
    }

    @RequestMapping("/myFavourite")
    public String myFavourite(){
        return "users/myFavourite";
    }
}