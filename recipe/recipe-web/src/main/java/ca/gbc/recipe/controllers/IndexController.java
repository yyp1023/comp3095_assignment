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
//        * Description: Controller for the main index / Login


package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    UserRepository urepo;

    @RequestMapping({"/index", "/", "index.html", ""})
    public String getLogin()
    {
        return "index";
    }

    @RequestMapping("/login")
    public String login_user(@RequestParam("username") String username, @RequestParam("password") String password,
                             HttpSession session, ModelMap modelMap) {

        User user = urepo.findByUsernamePassword(username, password);

        System.out.println(user);
        if (user != null) {
            String uname = user.getUsername();
            String upass = user.getPassword();

            if (username.equalsIgnoreCase(uname) && password.equalsIgnoreCase(upass)) {
                session.setAttribute("user", user);
                return "redirect:/users/";
            } else {
                modelMap.put("error", "Invalid Account");
                return "/index";
            }
        } else {
            modelMap.put("error", "Invalid Account");
            return "/index";
        }
    }

}
