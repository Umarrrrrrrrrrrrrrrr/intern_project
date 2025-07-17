package org.umar.learning.service;

import org.umar.learning.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(long id);
    Category save(Category category);
    Category update(long id,Category category);
    boolean delete(long id);
}
