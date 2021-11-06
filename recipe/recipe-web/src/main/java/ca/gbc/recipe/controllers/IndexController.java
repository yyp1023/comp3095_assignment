package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

//    @RequestMapping({"", "/", "index", "index.html"})
//    public String getUser(Model model) {
////        model.addAttribute("index", UserService.findById());
//        return "index";
//    }
    @Autowired
    UserRepository urepo;


    @PostMapping("/index")
    public String login_user(@RequestParam("username") String username, @RequestParam("password") String password,
                             HttpSession session, ModelMap modelMap) {

        User auser = urepo.findByUsernamePassword(username, password);

        if (auser != null) {
            String uname = auser.getUsername();
            String upass = auser.getPassword();

            if (username.equalsIgnoreCase(uname) && password.equalsIgnoreCase(upass)) {
                session.setAttribute("username", username);
                return "/users/index";
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
