package ca.gbc.recipe.services;

import ca.gbc.recipe.model.Favorites;
import ca.gbc.recipe.model.PlanMeal;
import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository repo;

    public void save(Favorites object) {
        repo.save(object);
    }

    public List<Favorites> findMyFav(User user) {
        return repo.findMyFav(user);
    }
}
