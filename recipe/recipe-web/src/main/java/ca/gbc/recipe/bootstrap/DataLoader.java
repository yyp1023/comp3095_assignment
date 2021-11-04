package ca.gbc.recipe.bootstrap;

import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.services.RecipeService;
import ca.gbc.recipe.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RecipeService recipeService;

    public DataLoader(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
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

    }
}
