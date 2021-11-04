package ca.gbc.recipe.bootstrap;

import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.services.RecipeService;
import ca.gbc.recipe.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        User user1 = new User();
        user1.setFirstname("YP");
        user1.setLastname("Yoo");
//        userService.save(user1);
//
//        User user2 = new User();
//        user2.setFirstname("Mark");
//        user2.setLastname("Trespeces");
//        userService.save(user2);
//
//        Recipe recipe1 = new Recipe();
//        recipe1.setName("Recipe 1");
//        recipeService.save(recipe1);
//
//        Recipe recipe2 = new Recipe();
//        recipe2.setName("Recipe 2");
//        recipeService.save(recipe2);
    }
}
