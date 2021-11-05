package ca.gbc.recipe.repository;

import ca.gbc.recipe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("from User where username=?1 and password=?2")
    public User findByUsernamePassword(String username, String password);

}