package org.umar.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.umar.learning.model.Inventory;
import org.umar.learning.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRespository) {
        this.inventoryRepository = inventoryRespository;
    }

    @Override
    public List<Inventory> findAll(){
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<Inventory> findById(Long id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory update(Long id, Inventory newInventory){
        return inventoryRepository.findById(id).map(existing -> {
            existing.setQuantity(newInventory.getQuantity());
            existing.setPrice(newInventory.getPrice());
            existing.setCategory(newInventory.getCategory());
            return inventoryRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        return inventoryRepository.findById(id).map(inventory -> {
            inventoryRepository.delete(inventory);
            return true;
        }).orElse(false);
    }
}
