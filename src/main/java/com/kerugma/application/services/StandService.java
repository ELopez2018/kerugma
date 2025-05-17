package com.kerugma.application.services;

import com.kerugma.infrastructure.persistence.entities.StandEntity;
import com.kerugma.infrastructure.persistence.repositories.StandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandService {
  private final StandRepository repository;

  public StandService(StandRepository repository) {
    this.repository = repository;
  }


  public List<StandEntity> findAll() {
    return repository.findAll();
  }


  public Optional<StandEntity> findById(Long id) {
    return repository.findById(id);
  }


  public StandEntity save(StandEntity stand) {
    return repository.save(stand);
  }


  public StandEntity update(Long id, StandEntity updated) {
    StandEntity existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Stand not found"));
    return repository.save(existing);
  }


  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new RuntimeException("Stand not found");
    }
    repository.deleteById(id);
  }
}
