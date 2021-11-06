package ca.gbc.recipe.services;

import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMap{

    @Autowired
    private UserRepository repo;

    public void save(User object) {
         repo.save(object);
    }
    public List<User> listAll() { return repo.findAll();}
}