package com.kerugma.application.services;

import com.kerugma.infrastructure.persistence.entities.InventoryEntity;
import com.kerugma.infrastructure.persistence.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

  private final InventoryRepository repository;

  public InventoryService(InventoryRepository repository) {
    this.repository = repository;
  }


  public List<InventoryEntity> findAll() {
    return repository.findAll();
  }


  public Optional<InventoryEntity> findById(Long id) {
    return repository.findById(id);
  }


  public InventoryEntity save(InventoryEntity inventory) {
    return repository.save(inventory);
  }


  public InventoryEntity update(Long id, InventoryEntity updated) {
    InventoryEntity existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Inventory not found"));
    existing.setStock(updated.getStock());
    return repository.save(existing);
  }


  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new RuntimeException("Inventory not found");
    }
    repository.deleteById(id);
  }
}
