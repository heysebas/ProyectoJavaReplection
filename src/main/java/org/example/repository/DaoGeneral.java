package org.example.repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class DaoGeneral<T> {

    protected List<T> dataStore = new ArrayList<>();

    // Retrieve all elements
    public List<T> getAll() {
        return dataStore;
    }

    // Retrieve element by ID
    public Optional<T> getById(int id) {
        for (T item : dataStore) {
            try {
                Field field = item.getClass().getDeclaredField("id");
                field.setAccessible(true);
                if (field.getInt(item) == id) {
                    return Optional.of(item);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    // Add an element
    public void add(T entity) {
        dataStore.add(entity);
    }

    // Delete an element by ID
    public boolean deleteById(int id) {
        Optional<T> entity = getById(id);
        if (entity.isPresent()) {
            dataStore.remove(entity.get());
            return true;
        }
        return false;
    }

    // Update an element by ID
    public boolean update(int id, T updatedEntity) {
        Optional<T> entity = getById(id);
        if (entity.isPresent()) {
            dataStore.remove(entity.get());
            dataStore.add(updatedEntity);
            return true;
        }
        return false;
    }
}