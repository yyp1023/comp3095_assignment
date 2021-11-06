package ca.gbc.recipe.bootstrap;

import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userService;

    private LocalDate localDate = LocalDate.now();

    @Autowired
    public DataLoader(UserRepository userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstname("Kent");
        user1.setLastname("Pedrocha");
        user1.setUsername("kpeds25");
        user1.setPassword("Kent");
        userService.save(user1);
        System.out.println("Dataloaded");
    }

}
