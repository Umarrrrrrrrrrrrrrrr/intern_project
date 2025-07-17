package org.umar.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umar.learning.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
