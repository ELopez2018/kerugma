package com.kerugma.adapters.in.rest;

import com.kerugma.application.services.DesignationService;
import com.kerugma.infrastructure.persistence.entities.DesignationEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nombramientos")
public class DesignationRestController {
  private final DesignationService service;

  public DesignationRestController(DesignationService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<DesignationEntity>> getAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<DesignationEntity> getById(@PathVariable Long id) {
    return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<DesignationEntity> create(@RequestBody DesignationEntity designation) {
    return ResponseEntity.ok(service.save(designation));
  }

  @PutMapping("/{id}")
  public ResponseEntity<DesignationEntity> update(@PathVariable Long id, @RequestBody DesignationEntity updated) {
    return ResponseEntity.ok(service.update(id, updated));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
