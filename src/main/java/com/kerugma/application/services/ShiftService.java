package com.kerugma.application.services;

import com.kerugma.infrastructure.persistence.entities.ShiftEntity;
import com.kerugma.infrastructure.persistence.repositories.ShiftRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShiftService {

  private final ShiftRepository repository;

  public ShiftService(ShiftRepository repository) {
    this.repository = repository;
  }


  public List<ShiftEntity> findAll() {
    return repository.findAll();
  }


  public Optional<ShiftEntity> findById(Long id) {
    return repository.findById(id);
  }


  public ShiftEntity save(ShiftEntity shift) {
    return repository.save(shift);
  }


  public ShiftEntity update(Long id, ShiftEntity updated) {
    ShiftEntity existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Shift not found"));

    return repository.save(existing);
  }


  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new RuntimeException("Shift not found");
    }
    repository.deleteById(id);
  }
}
