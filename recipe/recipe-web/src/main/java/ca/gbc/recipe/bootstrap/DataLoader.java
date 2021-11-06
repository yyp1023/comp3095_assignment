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
        recipe1.setEquipments("Tabo");
        recipe1.setDescription("Maligo");
        recipe1.setInstruction("HAHAHAHA");
        recipe1.setName("Masarap ako");
        recipe1.setStatus(true);
        recipe1.setType("Lunch");
        recipe1.setTime("LocalTime.now()");
        recipe1.setIngredients("ako ikaw mama mo");
        recipeService.save(recipe1);

        System.out.println("Dataloaded");




    }

}
