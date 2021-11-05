package ca.gbc.recipe.bootstrap;

import ca.gbc.recipe.model.PlanMeal;
import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.services.PlanMealService;
import ca.gbc.recipe.services.RecipeService;
import ca.gbc.recipe.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;


@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RecipeService recipeService;
    private final PlanMealService planMealService;
    private LocalDate localDate = LocalDate.now();


    public DataLoader(UserService userService, RecipeService recipeService, PlanMealService planMealService) {
        this.userService = userService;
        this.recipeService = recipeService;
        this.planMealService = planMealService;
    }

    @Override
    public void run(String... args) throws Exception {



    }
}
