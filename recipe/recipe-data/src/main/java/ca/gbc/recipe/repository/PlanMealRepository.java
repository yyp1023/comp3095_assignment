package ca.gbc.recipe.repository;

import ca.gbc.recipe.model.PlanMeal;
import ca.gbc.recipe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanMealRepository extends JpaRepository<PlanMeal, Long> {

}
