package ca.gbc.recipe.services;

import ca.gbc.recipe.model.ShoppingList;
import ca.gbc.recipe.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository repo;

    public void save(ShoppingList object) {
        repo.save(object);
    }

    public List<ShoppingList> findAll() { return repo.findAll(); }


}
