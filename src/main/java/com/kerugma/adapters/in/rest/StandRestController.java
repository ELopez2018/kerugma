package com.kerugma.adapters.in.rest;

import com.kerugma.application.services.StandService;
import com.kerugma.infrastructure.persistence.entities.StandEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stands")
public class StandRestController {

  private final StandService service;

  public StandRestController(StandService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<StandEntity>> getAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<StandEntity> getById(@PathVariable Long id) {
    return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<StandEntity> create(@RequestBody StandEntity stand) {
    return ResponseEntity.ok(service.save(stand));
  }

  @PutMapping("/{id}")
  public ResponseEntity<StandEntity> update(@PathVariable Long id, @RequestBody StandEntity updated) {
    return ResponseEntity.ok(service.update(id, updated));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
