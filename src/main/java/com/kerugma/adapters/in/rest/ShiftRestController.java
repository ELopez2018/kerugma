package com.kerugma.adapters.in.rest;

import com.kerugma.application.services.ShiftService;
import com.kerugma.infrastructure.persistence.entities.ShiftEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class ShiftRestController {

  private final ShiftService service;

  public ShiftRestController(ShiftService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<ShiftEntity>> getAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ShiftEntity> getById(@PathVariable Long id) {
    return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ShiftEntity> create(@RequestBody ShiftEntity shift) {
    return ResponseEntity.ok(service.save(shift));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ShiftEntity> update(@PathVariable Long id, @RequestBody ShiftEntity updated) {
    return ResponseEntity.ok(service.update(id, updated));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
