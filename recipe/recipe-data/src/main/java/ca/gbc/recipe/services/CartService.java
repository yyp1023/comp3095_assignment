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
//        * Description: Service operations for favourites

package ca.gbc.recipe.services;

import ca.gbc.recipe.model.Favorites;
import ca.gbc.recipe.model.ShoppingCart;
import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.CartRepository;
import ca.gbc.recipe.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository repo;

    public void save(ShoppingCart cart) {
        repo.save(cart);
    }

    public List<Favorites> findMyShoppingCart(User user) {
        return repo.findMyFav(user);
    }

    public void deleteCart(Long id) {
        repo.deleteCart(id);
    }
}