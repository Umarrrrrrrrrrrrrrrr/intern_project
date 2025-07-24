package org.umar.learning.service;

import org.springframework.stereotype.Service;
import org.umar.learning.model.Inventory;

import java.util.List;
import java.util.Optional;

@Service
public interface InventoryService {
    List<Inventory> findAll();
    Optional<Inventory> findById(Long id);
    Inventory save(Inventory inventory);
    Inventory update(Long id, Inventory inventory);
    boolean delete(Long id);
}
