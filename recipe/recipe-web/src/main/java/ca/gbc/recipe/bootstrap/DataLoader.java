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


        System.out.println("Dataloaded");




    }

}
