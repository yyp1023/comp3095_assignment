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
//        * Description: Many to many relationship for recipe and user PlanMeal



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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
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

    public String viewShortMonth()
    {
        switch (planned_date.getMonth() + 1)
        {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "July";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
            default:
                return "-";
        }
    }

    public Date getPlanned_date() {
        return planned_date;
    }


    public void setPlanned_date(Date planned_date) {
        this.planned_date = planned_date;
    }
}
