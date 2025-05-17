package com.kerugma.adapters.in.rest;

import com.kerugma.application.services.PointService;
import com.kerugma.infrastructure.persistence.entities.PointEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/puntos")
public class PointRestController {

  private final PointService service;

  public PointRestController(PointService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<PointEntity>> getAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<PointEntity> getById(@PathVariable Long id) {
    return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<PointEntity> create(@RequestBody PointEntity point) {
    return ResponseEntity.ok(service.save(point));
  }

  @PutMapping("/{id}")
  public ResponseEntity<PointEntity> update(@PathVariable Long id, @RequestBody PointEntity updated) {
    return ResponseEntity.ok(service.update(id, updated));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
