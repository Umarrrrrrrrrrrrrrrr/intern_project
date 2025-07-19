package org.umar.learning.service;

import org.springframework.stereotype.Service;
import org.umar.learning.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category category);
    Category update(Long id,Category category);
    boolean delete(Long id);
}
