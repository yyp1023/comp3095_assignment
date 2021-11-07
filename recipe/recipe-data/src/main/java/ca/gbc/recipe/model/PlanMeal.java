package ca.gbc.recipe.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "plan_meals")
public class PlanMeal extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_meal;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe user_selected_recipe;

    @Override
    public String toString() {
        return "PlanMeal{" +
                "user_meal=" + user_meal +
                ", user_selected_recipe=" + user_selected_recipe +
                ", planned_date=" + planned_date +
                '}';
    }

    @Column(name = "date_created")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planned_date;



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

    public Date getPlanned_date() {
        return planned_date;
    }

    public void setPlanned_date(Date planned_date) {
        this.planned_date = planned_date;
    }
}
