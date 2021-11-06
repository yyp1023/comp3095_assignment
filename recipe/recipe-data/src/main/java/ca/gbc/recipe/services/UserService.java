package ca.gbc.recipe.services;

import ca.gbc.recipe.model.User;
import ca.gbc.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService{

    @Autowired
    private UserRepository repo;

    public void save(User object) {
        repo.save(object);
    }

    public User getById(Integer id) { return repo.getById(id); }




}