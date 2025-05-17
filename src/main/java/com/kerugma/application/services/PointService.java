package com.kerugma.application.services;

import com.kerugma.infrastructure.persistence.entities.PointEntity;
import com.kerugma.infrastructure.persistence.repositories.PointRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointService {

  private final PointRepository repository;

  public PointService(PointRepository repository) {
    this.repository = repository;
  }


  public List<PointEntity> findAll() {
    return repository.findAll();
  }


  public Optional<PointEntity> findById(Long id) {
    return repository.findById(id);
  }


  public PointEntity save(PointEntity point) {
    return repository.save(point);
  }


  public PointEntity update(Long id, PointEntity updated) {
    PointEntity existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Point not found"));
    existing.setBenchmark(updated.getBenchmark()); // ajusta a tus campos reales
    return repository.save(existing);
  }

  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new RuntimeException("Point not found");
    }
    repository.deleteById(id);
  }
}
