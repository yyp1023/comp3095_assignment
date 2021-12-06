//* Project: < Recipe >
//        * Assignment: < assignment 1 >
//        * Author(s): < Young Pyung Yoo>
//                     < Kent Pedrocha >
//                     < John Jademar Lopez>
//                     <Mark Romel Trespeces>
//        * Student Number: < 101254379 >
//                          < 101266723 >
//                          < 101231787 >
//                          < 101258258 >
//        * Date: November 7, 2021
//        * Description: Many to many relationship for recipe and user favourites


package ca.gbc.recipe.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_cart;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe_cart;

    public User getUser_cart() {
        return user_cart;
    }

    public void setUser_cart(User user_cart) {
        this.user_cart = user_cart;
    }

    public Recipe getRecipe_cart() {
        return recipe_cart;
    }

    public void setRecipe_cart(Recipe recipe_cart) {
        this.recipe_cart = recipe_cart;
    }
}
