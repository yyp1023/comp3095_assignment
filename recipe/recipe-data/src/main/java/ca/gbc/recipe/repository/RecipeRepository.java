package ca.gbc.recipe.repository;

import ca.gbc.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r WHERE CONCAT(r.name, ' ', r.description, ' ') LIKE %?1% AND r.status = TRUE ")
    public List<Recipe> search(String keyword);

    @Query("SELECT r FROM Recipe r WHERE r.status = FALSE ")
    public List<Recipe> isPublic();
    @Query("from Recipe where id=?1")
    public Recipe findRecipeById(Long recipeId);
}
