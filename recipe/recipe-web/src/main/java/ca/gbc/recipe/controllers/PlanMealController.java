package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.PlanMeal;
import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.PlanMealRepository;
import ca.gbc.recipe.repository.RecipeRepository;
import ca.gbc.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@RequestMapping("/users/plan_meal")
@Controller
public class PlanMealController {
    @Autowired
    RecipeRepository recipeService;

    @Autowired
    PlanMealRepository planMealService;

    @Autowired
    UserRepository userService;

    @RequestMapping({"/planned_meals", "index", "/", ""})
    public String viewPlannedMeals(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        model.addAttribute("meals", planMealService.findPlannedMealsByUserId(user.getId()));
        return "/plan_meals/index";
    }

    @PostMapping(value= "/createPlan")
    public String planMealCreated(@ModelAttribute("planMeal") PlanMeal planMeal){
        planMealService.save(planMeal);
        return  "redirect:/users/plan_meal/index";
    }

    @RequestMapping({ "/createPlan"})
    public String createMeal(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        PlanMeal planmeal = new PlanMeal();
        planmeal.setUser_meal(userService.findUserById(user.getId()));
        model.addAttribute(planmeal);
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("recipes", recipeService.findAll());
        return "/plan_meals/createPlan";
    }

}
