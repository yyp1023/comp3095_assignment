package ca.gbc.recipe.services.map;

import ca.gbc.recipe.model.User;
import ca.gbc.recipe.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceMap extends AbstractServiceMap<User, Long> implements UserService {
    @Override
    public User save(User object) {
        return super.save(object);
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}