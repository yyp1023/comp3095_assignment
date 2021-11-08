package ca.gbc.recipe.repository;

import ca.gbc.recipe.model.Favorites;
import ca.gbc.recipe.model.Recipe;
import ca.gbc.recipe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorites, Long> {

    @Query("SELECT r FROM Favorites r WHERE r.user_fav =?1")
    public List<Favorites> findMyFav(User user_id);
}
