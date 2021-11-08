package ca.gbc.recipe.repository;

import java.util.List;

import ca.gbc.recipe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("from User where username=?1 and password=?2")
    public User findByUsernamePassword(String username, String password);

//    @Query("from User where id=?1")
//    public User findByUser(User user);
}
