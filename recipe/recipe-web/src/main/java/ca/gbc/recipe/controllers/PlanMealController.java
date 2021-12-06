//* Project: < Recipe >
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
//        * Description: Controller for planMeal and the logics behind data manipulations of the user and the system


package ca.gbc.recipe.controllers;

import ca.gbc.recipe.model.PlanMeal;
<<<<<<< HEAD
=======
import ca.gbc.recipe.model.Recipe;
>>>>>>> e63f879e186a8b3b91b5b643d4dd886b0c75b1f2
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.PlanMealRepository;
import ca.gbc.recipe.repository.RecipeRepository;
import ca.gbc.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.data.repository.query.Param;
>>>>>>> e63f879e186a8b3b91b5b643d4dd886b0c75b1f2
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
<<<<<<< HEAD
import java.time.LocalDate;
=======
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
>>>>>>> e63f879e186a8b3b91b5b643d4dd886b0c75b1f2

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
<<<<<<< HEAD
    public String planMealCreated(@ModelAttribute("planMeal") PlanMeal planMeal){
        planMealService.save(planMeal);
=======
    public String planMealCreated(@ModelAttribute("planMeal") PlanMeal planMeal, Model model){
        planMealService.save(planMeal);

>>>>>>> e63f879e186a8b3b91b5b643d4dd886b0c75b1f2
        return  "redirect:/users/plan_meal/index";
    }

    @RequestMapping({ "/createPlan"})
    public String createMeal(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        PlanMeal planmeal = new PlanMeal();
        planmeal.setUser_meal(userService.findUserById(user.getId()));
        model.addAttribute(planmeal);
<<<<<<< HEAD
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("recipes", recipeService.findAll());
        return "/plan_meals/createPlan";
    }

=======
        model.addAttribute("recipes", recipeService.findAll());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = new Date();
        String sdate = formatter.format(date);
        model.addAttribute("sdate", sdate );
        return "/plan_meals/createPlan";
    }

    @RequestMapping(value = "/delete/{mealId}", method= RequestMethod.POST)
    public String success(@PathVariable(name="mealId") Long mealId){
        planMealService.delete(planMealService.getById(mealId));
        return "redirect:/users/plan_meal/index";
    }

    @RequestMapping(value= "/update/{mealId}")
    public String planMealUpdate(@PathVariable(name="mealId") Long mealId, HttpSession session, Model model){
        PlanMeal planMeal = planMealService.getById(mealId);
        model.addAttribute("planMeal", planMeal);
        model.addAttribute("recipes", recipeService.findAll());
        return  "/plan_meals/update";
    }

    @PostMapping(value = "/update")
    public String mealUpdate(@Param("planMeal_id") Long planMeal_id, @Param("user_selected_recipe") String user_selected_recipe,
                             @Param("planned_date") String planned_date) throws ParseException {
        PlanMeal planMeal = planMealService.getById(planMeal_id);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = formatter.parse(planned_date);
        planMeal.setPlanned_date(date);
        Recipe recipe = recipeService.getById(Long.parseLong(user_selected_recipe));
        planMeal.setUser_selected_recipe(recipe);
        planMealService.save(planMeal);
        return "redirect:/users/plan_meal/index";
    }
>>>>>>> e63f879e186a8b3b91b5b643d4dd886b0c75b1f2
}
