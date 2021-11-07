package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.PlanMeal;
import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.services.PlanMealService;
import ca.gbc.recipe.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;

@RequestMapping("/user")
@Controller
public class PlanMealController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    PlanMealService planMealService;

    @RequestMapping({"/planned_meals"})
    public String viewPlannedMeals(){

        return "plan_meals/index";
    }

    @PostMapping(value= "/createPlan")
    public String createMeal(HttpSession session, Model model , @ModelAttribute("planMeal") PlanMeal planMeal){
        planMealService.save(planMeal);
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("time", LocalTime.now());
        return  "plan_meals/createPlan";
    }

    @RequestMapping({ "/createPlan"})
    public String createMeal(Model model){
        model.addAttribute("recipes", recipeService.findAll());
       return "plan_meals/createPlan";
    }

}
