package ca.gbc.recipe.bootstrap;

import ca.gbc.recipe.model.PlanMeal;
import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.services.PlanMealService;
import ca.gbc.recipe.services.RecipeService;
import ca.gbc.recipe.services.UserService;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


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


//        User user1 = new User();
//        user1.setFirstname("YP");
//        user1.setLastname("Yoo");
//        user1.setUsername("yyp");
//        user1.setPassword("1023");
//        user1.setFavorites(new HashSet<>(Arrays.asList()));

        Recipe recipe1 = new Recipe();
        recipe1.setName("Fried Rice");
//        recipe1.setUser(user1);
        recipe1.setEquipments(new HashSet<>(Arrays.asList("Pan", "Spoon")));
        recipe1.setIngredients(new HashSet<>(Arrays.asList("Rice", "Egg")));
        recipe1.setDescription("Delicious fried rice");
        recipe1.setInstruction("Cook rice, fry rice with egg");
        recipe1.setTime("1 hour");
        recipeService.create(recipe1);

        Recipe recipe2 = new Recipe();
        recipe2.setName("Recipe 2");
        recipeService.save(recipe2);


        PlanMeal planMeal1 = new PlanMeal();
        planMeal1.setUserID(user1.getId());
        planMeal1.setRecipeID(recipe1.getId());
        planMeal1.setDate(localDate);
        planMealService.save(planMeal1);
    }
}
