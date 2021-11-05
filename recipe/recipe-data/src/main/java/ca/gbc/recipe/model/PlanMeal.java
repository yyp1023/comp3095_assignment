package ca.gbc.recipe.model;

import java.time.LocalDate;

public class PlanMeal extends BaseEntity {
    private LocalDate date;
    private Long userID;
    private Long recipeID;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(Long recipeID) {
        this.recipeID = recipeID;
    }
}
