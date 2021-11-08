package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.PlanMeal;
import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.PlanMealRepository;
import ca.gbc.recipe.repository.RecipeRepository;
import ca.gbc.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@RequestMapping("/user/{userId}/plan_meal")
@Controller
public class PlanMealController {

    @Autowired
    RecipeRepository recipeService;

    @Autowired
    PlanMealRepository planMealService;

    @Autowired
    UserRepository userService;

    @RequestMapping({"/", "view", "index"})
    public String viewPlannedMeals(@PathVariable("userId") Long userId, Model model, HttpSession session){
        User user = userService.findUserById(userId);
        model.addAttribute("meals", planMealService.findPlannedMealsByUserId(userId));
        return "/plan_meals/index";
    }

    @PostMapping(value= "/createPlan")
    public String planMealCreated(@ModelAttribute("planMeal") PlanMeal planMeal){
        planMealService.save(planMeal);
        return  "redirect:/user/" + planMeal.getUser_meal().getId() + "/plan_meal/view";
    }

    @RequestMapping({ "/createPlan"})
    public String createMeal(@PathVariable("userId") Long userId, Model model){
        PlanMeal planmeal = new PlanMeal();
        planmeal.setUser_meal(userService.findUserById(userId));
        model.addAttribute(planmeal);
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("recipes", recipeService.findAll());
        return "/plan_meals/createPlan";
    }

}
