package ca.gbc.recipe.model;

import java.util.Set;

public class Recipe extends BaseEntity {
    private String name;
    private User user;
    private Set<String> equipments;
    private Set<String> ingredients;
    private String description;
    private String instruction;
    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<String> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<String> equipments) {
        this.equipments = equipments;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
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
}
