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
//        * Description: Service operations for PlanMeal


package ca.gbc.recipe.services;

import ca.gbc.recipe.model.PlanMeal;
import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.repository.PlanMealRepository;
import ca.gbc.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlanMealService {

    @Autowired
    private PlanMealRepository repo;

    public void save(PlanMeal object) {
        repo.save(object);
    }

}
