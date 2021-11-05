package ca.gbc.recipe.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "equipments")
    private String equipments;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "description")
    private String description;

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "time")
    private String time;

    @Column(name = "type")
    private String type;

    @Column(name = "dateCreated")
    private LocalDate dateCreated;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_recipe;

    @OneToMany(mappedBy = "recipe_fav")
    private Set<Favorites> favorites;

    @OneToMany(mappedBy = "user_selected_recipe")
    private Set<PlanMeal> planMeals;

    @ManyToOne
    @JoinColumn(name = "user_recipe")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquipments() {
        return equipments;
    }

    public void setEquipments(String equipments) {
        this.equipments = equipments;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser_recipe() {
        return user_recipe;
    }

    public void setUser_recipe(User user_recipe) {
        this.user_recipe = user_recipe;
    }

    public Set<Favorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorites> favorites) {
        this.favorites = favorites;
    }

    public Set<PlanMeal> getPlanMeals() {
        return planMeals;
    }

    public void setPlanMeals(Set<PlanMeal> planMeals) {
        this.planMeals = planMeals;
    }
}
