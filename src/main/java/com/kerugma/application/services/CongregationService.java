package com.kerugma.application.services;

import com.kerugma.infrastructure.persistence.entities.CongregationEntity;
import com.kerugma.infrastructure.persistence.repositories.CongregationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CongregationService {

  private final CongregationRepository repository;

  @Autowired
  public CongregationService(CongregationRepository repository) {
    this.repository = repository;
  }


  public List<CongregationEntity> findAll() {
    return repository.findAll();
  }


  public Optional<CongregationEntity> findById(Long id) {
    return repository.findById(id);
  }


  public CongregationEntity save(CongregationEntity congregation) {
    return repository.save(congregation);
  }


  public CongregationEntity update(Long id, CongregationEntity updated) {
    CongregationEntity existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Congregation not found"));
    // puedes copiar los campos actualizables aquí
    existing.setName(updated.getName());
    return repository.save(existing);
  }


  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new RuntimeException("Congregation not found");
    }
    repository.deleteById(id);
  }
}
