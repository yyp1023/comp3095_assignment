package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.User;
import ca.gbc.recipe.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping({"", "/", "/index", "index.html"})
    public String listUser(Model model) {
        //model.addAttribute("users", userService.findAll());
        return "users/index";
    }

    @RequestMapping("/register")
    public String userCreate(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "users/createOrUpdateUserForm";
    }

    @RequestMapping(value = "/registered")
    public String success(@ModelAttribute("user") User user){
        userService.save(user);
        /*
        * database codes here
        *
        * */

        //prints data just to check if this function is working
        System.out.println(user.getFirstname());
        System.out.println(user.getLastname());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "users/success";
    }

}
