//* Project: < Recipe >
//        * Assignment: < assignment 1 >
//        * Author(s): < Young Pyung Yoo>
//                     < Kent Pedrocha >
//                     < John Jademar Lopez>
//                     <Mark Romel Trespeces>
//        * Student Number: < 101254379 >
//                          < 101266723 >
//                          < 101231787 >
//                          < 101258258 >
//        * Date: November 7, 2021
//        * Description: Interface for Recipe Service


package ca.gbc.recipe.repository;

import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

=======
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
>>>>>>> e63f879e186a8b3b91b5b643d4dd886b0c75b1f2
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r WHERE CONCAT(r.name, ' ', r.description, ' ') LIKE %?1% AND r.status = FALSE")
    public List<Recipe> search(String keyword);

    @Query("SELECT r FROM Recipe r WHERE r.status = FALSE ")
    public List<Recipe> isPublic();

<<<<<<< HEAD
    @Query("from Recipe where id=?1")
=======
    @Query("SELECT r from Recipe r where r.id=?1")
>>>>>>> e63f879e186a8b3b91b5b643d4dd886b0c75b1f2
    public Recipe findRecipeById(Long recipeId);

    @Query("SELECT r FROM Recipe r WHERE r.user_id =?1")
    public List<Recipe> findByUser_id(User user_id);
<<<<<<< HEAD
=======


    @Transactional
    @Modifying
    @Query("DELETE FROM Recipe r WHERE r.user_id.id = ?1")
    void deleteMyRecipe(Long id);
>>>>>>> e63f879e186a8b3b91b5b643d4dd886b0c75b1f2
}
