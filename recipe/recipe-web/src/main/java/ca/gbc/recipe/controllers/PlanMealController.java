package ca.gbc.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/plan_meals")
@Controller
public class PlanMealController {

    @RequestMapping({"/planned_meals"})
    public String viewPlannedMeals(){

        return "plan_meals/index";
    }

    @RequestMapping({"/createPlan"})
    public String createMeal(){
        return  "plan_meals/createPlan";
    }

}
