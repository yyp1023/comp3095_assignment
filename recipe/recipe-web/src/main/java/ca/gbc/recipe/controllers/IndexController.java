package ca.gbc.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String getUser(Model model) {
//        model.addAttribute("index", UserService.findById());
        return "index";
    }

}
