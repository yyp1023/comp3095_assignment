package ca.gbc.recipe.repository;

import ca.gbc.recipe.model.PlanMeal;
import ca.gbc.recipe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanMealRepository extends JpaRepository<PlanMeal, Long> {

    @Query("from PlanMeal where user_meal.id=?1")
    public List<PlanMeal> findPlannedMealsByUserId(Long userId);
}
