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
//        * Description: Interface for PlanMeal Service


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
