package org.umar.learning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.umar.learning.model.Category;
import org.umar.learning.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<Category> getAll() {
        return categoryService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable long id) {
        return categoryService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable long id, @RequestBody Category category){
        Category updated = categoryService.update(id, category);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return categoryService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}