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
        recipe1.setEquipments("Cast Iron Pan \n" +
                "Meat Thermometer \n" +
                "Tongs");
        recipe1.setDescription("Great Japanese teriyaki-style marinated ribeye steak with a from-scratch teriyaki sauce.");
        recipe1.setInstruction("Step 1... Whisk together the soy sauce, water, sugar, honey, Worcestershire sauce, vinegar, olive oil, onion powder, garlic powder, and ground ginger in a large bowl. Pierce steaks several times with a fork. Marinate steaks in soy sauce mixture for at least 2 hours. \n" +
                "Step 2... Cook the steaks in a hot skillet, wok, or hibachi over medium heat; 7 minutes per side for medium. An instant-read thermometer inserted into the center should read 140 degrees F (60 degrees C).");
        recipe1.setName("Teriyaki Rib Eye Steaks");
        recipe1.setStatus(true);
        recipe1.setType("Dinner");
        recipe1.setTime("15 mins");
        recipe1.setIngredients("2 tablespoons soy sauce\n" +
                "2 tablespoons water\n" +
                "1 tablespoon white sugar\n" +
                "1.5 teaspoons honey\n" +
                "1.5 teaspoons Worcestershire sauce\n" +
                "1.5 teaspoons distilled white vinegar\n" +
                "1 teaspoon olive oil\n" +
                "¼ teaspoon onion powder\n" +
                "¼ teaspoon garlic powder\n" +
                "⅛ teaspoon ground ginger\n" +
                "2 (6 ounce) lean beef rib eye steaks");
        recipe1.setUser_id(user2);
        recipeService.save(recipe1);


        Recipe recipe2 = new Recipe();
        recipe2.setDateCreated(LocalDate.now());
        recipe2.setEquipments("Mixer, whisk, mixing bowl, waffle maker");
        recipe2.setDescription("A lovely, crispy waffle perfect for the morning.");
        recipe2.setInstruction("Step 1... In a large bowl, mix together flour, salt, baking powder and sugar; set aside. Preheat waffle iron to desired temperature. \n" +
                "Step 2... In a separate bowl, beat the eggs. Stir in the milk, butter and vanilla. Pour the milk mixture into the flour mixture; beat until blended. \n" +
                "Step 3... Ladle the batter into a preheated waffle iron. Cook the waffles until golden and crisp. Serve immediately.");
        recipe2.setName("Classic Waffles");
        recipe2.setStatus(true);
        recipe2.setType("Breakfast");
        recipe2.setTime("25 mins");
        recipe2.setIngredients("2 cups all-purpose flour\n" +
                "1 teaspoon salt\n" +
                "4 teaspoons baking powder\n" +
                "2 tablespoons white sugar\n" +
                "2 eggs\n" +
                "1.5 cups warm milk\n" +
                "0.5 cup butter, melted\n" +
                "1 teaspoon vanilla extract");
        recipe2.setUser_id(user1);
        recipeService.save(recipe2);

    }

}
