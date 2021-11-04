package ca.gbc.recipe.controllers;

import ca.gbc.recipe.services.PlanMealService;
import ca.gbc.recipe.services.RecipeService;
import ca.gbc.recipe.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users/plan_meals")
@Controller
public class PlanMealController {

    private final PlanMealService planMealService;

    public PlanMealController(PlanMealService planMealService, RecipeService recipeService, UserService userService) {
        this.planMealService = planMealService;
    }

    @RequestMapping({"", "/", "/index", "index.html"})
    public String listUser(Model model) {
        model.addAttribute("planMeals", planMealService.findAll());






        return "users/plan_meals/index";
    }
}
