package ca.gbc.recipe.services;

public interface CrudService<T> {
    T create(T object);
}
