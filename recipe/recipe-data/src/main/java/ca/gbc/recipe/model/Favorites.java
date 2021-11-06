package ca.gbc.recipe.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "favorites")
public class Favorites extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_fav;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe_fav;

    public User getUser_fav() {
        return user_fav;
    }

    public void setUser_fav(User user_fav) {
        this.user_fav = user_fav;
    }

    public Recipe getRecipe_fav() {
        return recipe_fav;
    }

    public void setRecipe_fav(Recipe recipe_fav) {
        this.recipe_fav = recipe_fav;
    }
}
