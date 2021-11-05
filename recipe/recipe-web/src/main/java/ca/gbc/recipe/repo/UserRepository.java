//package ca.gbc.recipe.repo;
//
//import ca.gbc.recipe.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    @Query("from User where user_email=?1 and user_pass=?2")
//    public User findById(String username,String password);
//
//}
