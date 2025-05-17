package com.kerugma.application.services;

import com.kerugma.infrastructure.persistence.entities.DesignationEntity;
import com.kerugma.infrastructure.persistence.repositories.DesignationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignationService {
  private final DesignationRepository repository;

  public DesignationService(DesignationRepository repository) {
    this.repository = repository;
  }


  public List<DesignationEntity> findAll() {
    return repository.findAll();
  }


  public Optional<DesignationEntity> findById(Long id) {
    return repository.findById(id);
  }


  public DesignationEntity save(DesignationEntity designation) {
    return repository.save(designation);
  }


  public DesignationEntity update(Long id, DesignationEntity updated) {
    DesignationEntity existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Designation not found"));
    existing.setDescription(updated.getDescription());
    return repository.save(existing);
  }


  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new RuntimeException("Designation not found");
    }
    repository.deleteById(id);
  }
}
