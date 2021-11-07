package ca.gbc.recipe.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plan_meal")
public class PlanMeal extends BaseEntity {

    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_meal;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe user_selected_recipe;

    @Column(name = "date_created")
    private LocalDate date_created;



    public User getUser_meal() {
        return user_meal;
    }

    public void setUser_meal(User user_meal) {
        this.user_meal = user_meal;
    }

    public Recipe getUser_selected_recipe() {
        return user_selected_recipe;
    }

    public void setUser_selected_recipe(Recipe user_selected_recipe) {
        this.user_selected_recipe = user_selected_recipe;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }
}
