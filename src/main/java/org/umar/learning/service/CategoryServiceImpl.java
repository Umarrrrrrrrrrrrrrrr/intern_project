package org.umar.learning.service;

import org.springframework.stereotype.Service;
import org.umar.learning.model.Category;
import org.umar.learning.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    //Construction injection
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id){
       return categoryRepository.findById(id);
    }

    @Override
    public Category update(Long id, Category category) {
        return categoryRepository.findById(id).map(existing -> {
            existing.setName(category.getName());
            return categoryRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        return categoryRepository.findById(id).map(existing -> {
            categoryRepository.delete(existing);
            return true;
        }).orElse(false);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
