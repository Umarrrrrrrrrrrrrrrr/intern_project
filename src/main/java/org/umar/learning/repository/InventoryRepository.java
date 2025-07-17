package org.umar.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umar.learning.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
