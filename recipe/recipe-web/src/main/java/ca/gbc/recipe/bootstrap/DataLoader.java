package ca.gbc.recipe.bootstrap;

import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.RecipeRepository;
import ca.gbc.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;


@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userService;
    private final RecipeRepository recipeService;

    private LocalDate localDate = LocalDate.now();

    @Autowired
    public DataLoader(UserRepository userService, RecipeRepository recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstname("Kent");
        user1.setLastname("Pedrocha");
        user1.setUsername("kpeds25");
        user1.setPassword("Kent");
        userService.save(user1);

        User user2 = new User();
        user2.setFirstname("Mark");
        user2.setLastname("Trespeces");
        user2.setUsername("mtres");
        user2.setPassword("tres");
        userService.save(user2);

        User user3 = new User();
        user3.setFirstname("John");
        user3.setLastname("Lopez");
        user3.setUsername("jlopez");
        user3.setPassword("jj");
        userService.save(user3);

        User user4 = new User();
        user4.setFirstname("Young Pyung");
        user4.setLastname("Yoo");
        user4.setUsername("ypyoo");
        user4.setPassword("yoo");
        userService.save(user4);


        Recipe recipe1 = new Recipe();
        recipe1.setDateCreated(LocalDate.now());
        recipe1.setEquipments("Meat Thermometer, Cast iron pan, Tongs");
        recipe1.setDescription("Great Japanese teriyaki-style marinated ribeye steak with a from-scratch teriyaki sauce.");
        recipe1.setInstruction("Cook the steaks in a hot skillet, wok, or hibachi over medium heat; 7 minutes per side for medium. " +
                "An instant-read thermometer inserted into the center should read 140 degrees F (60 degrees C). ");
        recipe1.setName("Teriyaki Rib Eye Steaks");
        recipe1.setStatus(false);
        recipe1.setType("Dinner");
        recipe1.setTime("2.5 hours");
        recipe1.setIngredients("2 tablespoons soy sauce, 2 tablespoons water, 1 tablespoon white sugar, 1 teaspoon olive oil, 2 (6 ounce) lean beef rib eye steaks");
        recipe1.setUser_id(user2);
        recipeService.save(recipe1);


        Recipe recipe2 = new Recipe();
        recipe2.setDateCreated(LocalDate.now());
        recipe2.setEquipments("Mixing bowl, waffle maker, whisk, mixer");
        recipe2.setDescription("A lovely, crispy waffle perfect for the morning.");
        recipe2.setInstruction("In a large bowl, mix together flour, salt, baking powder and sugar; set aside. Preheat waffle iron to desired temperature.");
        recipe2.setName("Classic Waffles");
        recipe2.setStatus(false);
        recipe2.setType("Breakfast");
        recipe2.setTime("25 mins");
        recipe2.setIngredients("2 cups all-purpose flour, 1 teaspoon salt, 4 teaspoons baking powder, 2 tablespoons white sugar");
        recipe2.setUser_id(user1);
        recipeService.save(recipe2);

        Recipe recipe3 = new Recipe();
        recipe3.setDateCreated(LocalDate.now());
        recipe3.setEquipments("Pots, Bowls, Chopsticks");
        recipe3.setDescription("The easiest ramen you will ever make in less than 30 min. And it’s so much tastier (and healthier) than the store-bought version!");
        recipe3.setInstruction("Heat olive oil in a large stockpot or Dutch oven over medium heat. Add garlic and ginger, and cook, stirring frequently, until fragrant, about 1-2 minutes. Whisk in chicken broth, mushrooms, soy sauce and 3 cups water.");
        recipe3.setName("EASY HOMEMADE RAMEN");
        recipe3.setStatus(true);
        recipe3.setType("Dinner");
        recipe3.setTime("30 mins");
        recipe3.setIngredients("4 cups reduced sodium chicken broth, 4 ounces shiitake mushrooms, 1 carrot, grated, 2 tablespoons chopped chives");
        recipe3.setUser_id(user3);
        recipeService.save(recipe3);

    }

}
