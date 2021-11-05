package ca.gbc.recipe.services.map;

import ca.gbc.recipe.model.PlanMeal;
import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.services.PlanMealService;
import ca.gbc.recipe.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlanMealServiceMap extends AbstractServiceMap<PlanMeal, Long> implements PlanMealService {
    @Override
    public PlanMeal save(PlanMeal object) {
        return super.save(object);
    }

    @Override
    public Set<PlanMeal> findAll() {
        return super.findAll();
    }

    @Override
    public PlanMeal findById(Long id) {
        return null;
    }
}
