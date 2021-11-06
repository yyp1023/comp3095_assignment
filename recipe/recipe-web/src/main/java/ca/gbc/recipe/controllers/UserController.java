package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.User;
import ca.gbc.recipe.services.UserServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    UserServiceMap userService;

//    @RequestMapping({"", "/", "/index", "index.html"})
//    public String listUser(Model model) {
////        model.addAttribute("users", userService.findAll());
//        return "users/index";
//    }
//
//    @RequestMapping({"/profile"})
//    public String showProfile(Model model) {
////        model.addAttribute("users", userService.findById());
//        return "users/index";
//    }



//    @PostMapping({"", "/", "/index", "index.html"})
//    public String login_user(@RequestParam("username") String username, @RequestParam("password") String password,
//                             HttpSession session, ModelMap modelMap)
//    {
//
//        User user = urepo.findByUsernamePassword(username, password);
//
//        if(user != null)
//        {
//            String name = user.getUsername();
//            String pass = user.getPassword();
//
//            if(username.equalsIgnoreCase(name) && password.equalsIgnoreCase(pass))
//            {
//                // add session and direct to welcome or index
//                session.setAttribute("username",username);
//                return "welcome";
//            }
//            else
//            {
//                // error login reload index page
//                modelMap.put("error", "Invalid Account");
//                return "index";
//            }
//        }
//        else
//        {
//            // error login reload index page
//            modelMap.put("error", "Invalid Account");
//            return "index";
//        }
//
//    }

    @RequestMapping("/register")
    public String userCreate(Model model){
        User user = new User();
        model.addAttribute(user);
        return "users/register";
    }

    @RequestMapping(value = "/registered", method= RequestMethod.POST)
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
