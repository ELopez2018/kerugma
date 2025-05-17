package com.kerugma.adapters.in.rest;

import com.kerugma.application.services.InventoryService;
import com.kerugma.infrastructure.persistence.entities.InventoryEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventoryController {

  private final InventoryService service;

  public InventoryController(InventoryService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<InventoryEntity>> getAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<InventoryEntity> getById(@PathVariable Long id) {
    return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<InventoryEntity> create(@RequestBody InventoryEntity inventory) {
    return ResponseEntity.ok(service.save(inventory));
  }

  @PutMapping("/{id}")
  public ResponseEntity<InventoryEntity> update(@PathVariable Long id, @RequestBody InventoryEntity updated) {
    return ResponseEntity.ok(service.update(id, updated));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}