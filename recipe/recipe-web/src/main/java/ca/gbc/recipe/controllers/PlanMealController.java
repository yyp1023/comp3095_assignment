package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.PlanMeal;
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

    @RequestMapping({"/planned_meals"})
    public String viewPlannedMeals(){

        return "plan_meals/index";
    }

    @PostMapping(value= "/createPlan")
    public String planMealCreated(@ModelAttribute("planMeal") PlanMeal planMeal){
        planMealService.save(planMeal);
        return  "plan_meals/index";
    }

    @RequestMapping({ "/createPlan"})
    public String createMeal(@PathVariable("userId") Long userId, Model model, @RequestParam(name = "setUser_selected_recipe") Long setUser_selected_recipe){
        PlanMeal planmeal = new PlanMeal();
        planmeal.setUser_meal(userService.findUserById(userId));
        planmeal.setUser_selected_recipe(recipeService.findRecipeById(setUser_selected_recipe));
        model.addAttribute(planmeal);
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("recipes", recipeService.findAll());
        return "/plan_meals/createPlan";
    }

}
