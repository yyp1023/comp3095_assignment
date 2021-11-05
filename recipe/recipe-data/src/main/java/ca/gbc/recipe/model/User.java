package ca.gbc.recipe.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name ="first_name")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user_recipe")
    private Set<Recipe> recipes;

    @OneToMany(mappedBy = "recipe_fav")
    private Set<Favorites> selected_user;

    @OneToMany(mappedBy = "user_meal")
    private Set<PlanMeal> planMeals;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Set<Favorites> getSelected_user() {
        return selected_user;
    }

    public void setSelected_user(Set<Favorites> selected_user) {
        this.selected_user = selected_user;
    }

    public Set<PlanMeal> getPlanMeals() {
        return planMeals;
    }

    public void setPlanMeals(Set<PlanMeal> planMeals) {
        this.planMeals = planMeals;
    }
}
