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
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r WHERE CONCAT(r.name, ' ', r.description, ' ') LIKE %?1% AND r.status = FALSE")
    public List<Recipe> search(String keyword);

    @Query("SELECT r FROM Recipe r WHERE r.status = FALSE ")
    public List<Recipe> isPublic();

    @Query("from Recipe where id=?1")
    public Recipe findRecipeById(Long recipeId);

    @Query("SELECT r FROM Recipe r WHERE r.user_id =?1")
    public List<Recipe> findByUser_id(User user_id);
}
