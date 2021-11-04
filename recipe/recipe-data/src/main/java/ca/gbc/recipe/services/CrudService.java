package ca.gbc.recipe.services;

import java.util.Set;

public interface CrudService<T, ID> {
    T save(T object);
    Set<T> findAll();
    T findById(ID id);
}