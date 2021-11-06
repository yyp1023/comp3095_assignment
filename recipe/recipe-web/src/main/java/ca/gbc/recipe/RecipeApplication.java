package ca.gbc.recipe;

import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RecipeApplication {

	public static void main(String[] args) {
				SpringApplication.run(RecipeApplication.class, args);
	}


}
