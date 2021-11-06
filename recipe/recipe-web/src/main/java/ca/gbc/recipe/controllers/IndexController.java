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
                session.setAttribute("username", username);
                return "redirect:/users/index";
            } else {
                modelMap.put("error", "Invalid Account");
                return "/index";
            }
        } else {
            modelMap.put("error", "Invalid Account");
            return "index";
        }
    }

}
